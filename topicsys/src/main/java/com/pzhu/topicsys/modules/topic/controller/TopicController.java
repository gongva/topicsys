package com.pzhu.topicsys.modules.topic.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pzhu.topicsys.common.base.BaseController;
import com.pzhu.topicsys.common.mybatis.entity.Topic;
import com.pzhu.topicsys.common.mybatis.mapper.TopicMapper;
import com.pzhu.topicsys.common.util.JsonResponse;
import com.pzhu.topicsys.common.util.PageBounds;
import com.pzhu.topicsys.common.util.PageResult;
import com.pzhu.topicsys.modules.topic.model.TopicDetail;
import com.pzhu.topicsys.modules.topic.service.TopicService;

/**
 * Desc： 课题管理模块Controller
 *
 */
@RestController
public class TopicController extends BaseController {

    @Value("${paper.address}")
    private String paperRootPath;
    @Resource
    private TopicService topicService;
    @Resource
    private TopicMapper topicMapper;

    /**
     * Desc：获取课题列表
     * 
     * @param userId
     * @param tName
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(path = "/topic/list", method = RequestMethod.GET)
    public JsonResponse getTopicList(String userId, String tName, PageBounds page) {
        PageResult result = this.topicService.findTopics(userId, tName, page);
        JsonResponse res = JsonResponse.success(result);
        return res;
    }

    /**
     * Desc：课题新增/修改
     * 
     * @param userId
     * @param topicId
     * @param name
     * @param description
     * @return
     */
    @RequestMapping(path = "/topic/save", method = RequestMethod.POST)
    public JsonResponse save(String userId, String topicId, String name, String description) {
        boolean result = this.topicService.save(userId, topicId, name, description);
        if (result) {
            return JsonResponse.success();
        } else {
            return JsonResponse.fail(ApiErrorMsgPost);
        }
    }

    /**
     * Desc:删除课题
     * 
     * @param topicId
     * @return
     */
    @RequestMapping(path = "/topic/delete", method = RequestMethod.POST)
    public JsonResponse deleteTopic(String topicId) {
        boolean result = this.topicService.deleteTopic(topicId);
        if (result) {
            return JsonResponse.success();
        } else {
            return JsonResponse.fail(ApiErrorMsgPost);
        }
    }

    /**
     * Desc:课题审核
     * 
     * @param topicId
     * @param status  4-审核通过 5-审核不通过
     * @return
     */
    @RequestMapping(path = "/topic/validate", method = RequestMethod.POST)
    public JsonResponse validateTopic(String topicId, int status) {
        boolean result = this.topicService.validateTopic(topicId, status);
        if (result) {
            return JsonResponse.success();
        } else {
            return JsonResponse.fail(ApiErrorMsgPost);
        }
    }

    /**
     * Desc:课题选报
     * 
     * @param topicId
     * @param sId:学生ID
     * @return
     */
    @RequestMapping(path = "/topic/sign", method = RequestMethod.POST)
    public JsonResponse signTopic(String topicId, String sId) {
        boolean result = this.topicService.signTopic(topicId, sId);
        if (result) {
            return JsonResponse.success();
        } else {
            return JsonResponse.fail(ApiErrorMsgPost);
        }
    }

    /**
     * Desc:论文上传
     * 
     * @param topicId
     * @param file
     * @return
     */
    @RequestMapping(path = "/topic/uploadPaper", method = RequestMethod.POST)
    public JsonResponse uoloadPaper(String topicId, MultipartFile file) {
        boolean result = this.topicService.uoloadPaper(topicId, file);
        if (result) {
            return JsonResponse.success();
        } else {
            return JsonResponse.fail(ApiErrorMsgPost);
        }
    }

    /**
     * Desc:论文下载
     * 
     * @param topicId
     * @return
     */
	@RequestMapping(path = "/topic/downloadPaper", method = RequestMethod.GET)
    public void downloadPaper(String topicId, HttpServletResponse response) {
        Topic topic = this.topicMapper.selectByPrimaryKey(topicId);
        try {
            if (topic == null) {
                ServletOutputStream sos = response.getOutputStream();
                response.setCharacterEncoding("UTF-8");
                sos.write("查无此课题".getBytes());
                return;
            }
            if (topic.getPaperAddress() == null || topic.getPaperAddress().equals("")) {
                ServletOutputStream sos = response.getOutputStream();
                response.setCharacterEncoding("UTF-8");
                sos.write("学生还未上传论文".getBytes());
                return;
            }
            String fileName = topic.getPaperAddress();
            String filePath = paperRootPath + File.separator + topic.getTopicName() + File.separator + fileName;
            File targetFile = new File(filePath);

            if (!targetFile.exists()) {
                ServletOutputStream sos = response.getOutputStream();
                response.setCharacterEncoding("UTF-8");
                sos.write("文件不存在或已被删除".getBytes());
                return;
            }

            // 下载的文件携带这个名称
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            // 文件下载类型--二进制文件
            response.setContentType("application/octet-stream");
            FileInputStream fis = new FileInputStream(filePath);
            byte[] content = new byte[fis.available()];
            fis.read(content);
            fis.close();

            ServletOutputStream sos = response.getOutputStream();
            sos.write(content);

            sos.flush();
            sos.close();
        } catch (Exception e) {
            try {
                ServletOutputStream sos = response.getOutputStream();
                response.setCharacterEncoding("UTF-8");
                sos.write("下载出错".getBytes());
                return;
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * Desc:获取课题详情
     * 
     * @param topicId
     * @return
     */
    @RequestMapping(path = "/topic/detail", method = RequestMethod.GET)
    public JsonResponse getTopicDetail(String topicId, String sId) {
        TopicDetail detail = this.topicService.getTopicDetail(topicId);
        return JsonResponse.success(detail);
    }
}
