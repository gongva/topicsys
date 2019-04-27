package com.pzhu.topicsys.modules.topic.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;
import com.pzhu.topicsys.common.base.Constants;
import com.pzhu.topicsys.common.exception.BusinessException;
import com.pzhu.topicsys.common.mybatis.entity.Topic;
import com.pzhu.topicsys.common.mybatis.entity.User;
import com.pzhu.topicsys.common.mybatis.mapper.SystemConfigMapper;
import com.pzhu.topicsys.common.mybatis.mapper.TopicMapper;
import com.pzhu.topicsys.common.mybatis.mapper.UserMapper;
import com.pzhu.topicsys.common.util.DateUtil;
import com.pzhu.topicsys.common.util.PageBounds;
import com.pzhu.topicsys.common.util.PageResult;
import com.pzhu.topicsys.common.util.RandUtil;
import com.pzhu.topicsys.modules.topic.model.TopicDetail;
import com.pzhu.topicsys.modules.topic.model.TopicList;
import com.pzhu.topicsys.modules.topic.service.TopicService;

@Service
public class TopicServiceImpl implements TopicService {

    @Value("${paper.address}")
    private String paperRootPath;
    @Resource
    private UserMapper userMapper;
    @Resource
    private TopicMapper topicMapper;
    @Resource
    private SystemConfigMapper systemConfigMapper;

    @Override
    public PageResult findTopics(String userId, String tName, PageBounds page) {
        User user = this.userMapper.selectByPrimaryKey(userId);
        if (user == null) {
            throw new BusinessException("无效的操作用户");
        }
        // 管理员：按导师姓名搜索课题
        // 导师：查自己创建的课题
        // 学生：已报名-查询报名的课题；未报名-查自己院系所有导师的所有课题
        switch (user.getRole()) {
        case Constants.ROLE_CODE_ADMIN:
        case Constants.ROLE_CODE_MANAGER:
            Page<TopicList> listForManager = this.topicMapper.findTopics(tName, page.toRowBounds());
            return new PageResult(page.getPage(), page.getSize(), listForManager);
        case Constants.ROLE_CODE_TEACHER:
            Page<TopicList> listForTID = this.topicMapper.findTopicsByTid(userId, tName, page.toRowBounds());
            return new PageResult(page.getPage(), page.getSize(), listForTID);
        case Constants.ROLE_CODE_STUDENT:
            Topic topicSign = this.topicMapper.selectByUserId(userId);
            if (topicSign != null) {
                Page<TopicList> listForSID = this.topicMapper.findTopicsBySid(userId, tName, page.toRowBounds());
                return new PageResult(page.getPage(), page.getSize(), listForSID);
            } else {
                Page<TopicList> listForSDepartment = this.topicMapper.findTopicsBySDepartment(userId, tName,
                        page.toRowBounds());
                return new PageResult(page.getPage(), page.getSize(), listForSDepartment);
            }
        default:
            return new PageResult(page.getPage(), page.getSize(), null);
        }
    }

    @Override
    public boolean save(String userId, String topicId, String name, String description) {
        if (name == null) {
            throw new BusinessException("缺少参数");
        }
        Topic topicTemp = this.topicMapper.getTopicByName(name);
        if (topicTemp != null) {
            throw new BusinessException(String.format("%s已经存在，不允许重复", name));
        }
        if (topicId == null) {
            // 新增
            User user = this.userMapper.selectByPrimaryKey(userId);
            if (user == null) {
                throw new BusinessException("无效的操作用户");
            }
            if (!Constants.ROLE_CODE_TEACHER.equals(user.getRole())) {
                throw new BusinessException("您不是导师，无法创建课题");
            }
            Topic topic = new Topic();
            topic.setTopicId(RandUtil.uuid());
            topic.setTopicName(name);
            topic.setDescription(description);
            topic.settUserId(user.getUserId());
            topic.setStatus(Constants.TOPIC_STATUS_TO_SIGN);
            topic.setCreateTime(new Date());
            topic.setIsDelete(0);
            topic.setUpdateTime(new Date());
            int lines = this.topicMapper.insertSelective(topic);
            return lines > 0;
        } else {
            // 修改
            Topic topicDB = this.topicMapper.selectByPrimaryKey(topicId);
            if (topicDB == null) {
                throw new BusinessException("查无此课题");
            }
            topicDB.setTopicName(name);
            topicDB.setDescription(description);
            topicDB.setUpdateTime(new Date());
            int lines = this.topicMapper.updateByPrimaryKeySelective(topicDB);
            return lines > 0;
        }
    }

    @Override
    public boolean deleteTopic(String topicId) {
        if (topicId == null) {
            throw new BusinessException("缺少参数");
        }
        Topic topic = this.topicMapper.selectByPrimaryKey(topicId);
        if (topic == null) {
            throw new BusinessException("查无此课题");
        }

        topic.setIsDelete(Constants.IS_DELETE_DELETED);
        topic.setUpdateTime(new Date());

        int result = this.topicMapper.updateByPrimaryKeySelective(topic);
        return result > 0;
    }

    @Override
    public boolean validateTopic(String topicId, int status) {
        if (topicId == null || status == 0) {
            throw new BusinessException("缺少参数");
        }
        Topic topicDB = this.topicMapper.selectByPrimaryKey(topicId);
        if (topicDB == null) {
            throw new BusinessException("查无此课题");
        }

        topicDB.setStatus(status);
        topicDB.setUpdateTime(new Date());
        int lines = this.topicMapper.updateByPrimaryKeySelective(topicDB);
        return lines > 0;
    }

    @Override
    public boolean signTopic(String topicId, String sId) {
        if (topicId == null || sId == null) {
            throw new BusinessException("缺少参数");
        }

        Topic topicDB = this.topicMapper.selectByPrimaryKey(topicId);
        if (topicDB == null) {
            throw new BusinessException("查无此课题");
        }
        if (topicDB.getsUserId() != null) {
            throw new BusinessException("抱歉，该课题已被其他人选报");
        }

        String timeStartTxt = systemConfigMapper.getValueByCode(Constants.PAPER_TIME_START);
        String timeEndTxt = systemConfigMapper.getValueByCode(Constants.PAPER_TIME_END);
        Date timeStart = DateUtil.parseDate(timeStartTxt);
        Date timeEnd = DateUtil.parseDate(timeEndTxt);
        Date now = new Date();
        if ((timeStart != null && now.getTime() < timeStart.getTime())
                || (timeEnd != null && now.getTime() > timeEnd.getTime())) {
            throw new BusinessException("当前不在选题时间范围内");
        }

        Topic topicSigned = this.topicMapper.selectByUserId(sId);
        if (topicSigned != null) {
            throw new BusinessException("您已选报过课题，不能重复选报");
        }

        topicDB.setStatus(Constants.TOPIC_STATUS_TO_UPLOAD);
        topicDB.setsUserId(sId);
        topicDB.setUpdateTime(new Date());
        int lines = this.topicMapper.updateByPrimaryKeySelective(topicDB);
        return lines > 0;
    }

    @Override
    public boolean uoloadPaper(String topicId, MultipartFile file) {
        if (topicId == null || file == null) {
            throw new BusinessException("缺少参数");
        }
        Topic topicDB = this.topicMapper.selectByPrimaryKey(topicId);
        if (topicDB == null) {
            throw new BusinessException("查无此课题");
        }
        // 定义文件名
        //String fileName = RandUtil.uuid();
        //String fileSuffix = getFileSuffix(file);
        //if (fileSuffix != null) {
        //    fileName += fileSuffix;
        //}
        String fileName = file.getOriginalFilename();

        // 定义存储路径
        String directoryPath = paperRootPath + File.separator + topicDB.getTopicName() + File.separator;
        File directoryFile = new File(directoryPath);
        if (!directoryFile.exists()) {
            directoryFile.mkdirs();
        }

        // 定义保存的目标文件
        String filePath = directoryPath + fileName;
        File targetFile = new File(filePath);

        // 保存文件
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(targetFile);
            IOUtils.copy(file.getInputStream(), fileOutputStream);
        } catch (IOException e) {
            throw new BusinessException("上传失败，请联系系统管理员");
        } finally {
            try {
                fileOutputStream.close();
            } catch (Exception e) {
                throw new BusinessException("上传失败，请联系系统管理员");
            }
        }

        // 更新DB
        topicDB.setPaperAddress(fileName);
        topicDB.setStatus(Constants.TOPIC_STATUS_TO_VALIDATE);
        topicDB.setUpdateTime(new Date());
        int lines = this.topicMapper.updateByPrimaryKeySelective(topicDB);
        return lines > 0;
    }

    @Override
    public TopicDetail getTopicDetail(String topicId) {
        if (topicId == null) {
            throw new BusinessException("缺少参数");
        }
        TopicDetail detail = this.topicMapper.getTopicDetail(topicId);
        if (detail == null) {
            throw new BusinessException("查无此课题");
        }
        return detail;
    }

    /**
     * DESC：获取文件后缀名
     * 
     * @param file
     * @return
     */
    private String getFileSuffix(MultipartFile file) {
        if (file == null) {
            return null;
        }
        String fileName = file.getOriginalFilename();
        int suffixIndex = fileName.lastIndexOf(".");
        if (suffixIndex == -1) { // 无后缀
            return null;
        } else { // 存在后缀
            return fileName.substring(suffixIndex, fileName.length());
        }
    }
}
