package com.pzhu.topicsys.modules.topic.service;

import org.springframework.web.multipart.MultipartFile;

import com.pzhu.topicsys.common.util.PageBounds;
import com.pzhu.topicsys.common.util.PageResult;
import com.pzhu.topicsys.modules.topic.model.TopicDetail;

/**
 * Desc： 课题管理Service
 *
 */
public interface TopicService {

    /**
     * Desc：查询课题列表
     * 
     * @param userId
     * @param tName
     * @param page
     * @return
     */
    PageResult findTopics(String userId, String tName, PageBounds page);

    /**
     * Desc：新增/修改课题
     * 
     * @param userId
     * @param topicId
     * @param name
     * @param description
     * @return
     */
    boolean save(String userId, String topicId, String name, String description);

    /**
     * Desc:删除课题
     * 
     * @param topicId
     * @return
     */
    boolean deleteTopic(String topicId);

    /**
     * Desc:课题审核
     * 
     * @param topicId
     * @param status: 4-审核通过 5-审核不通过
     * @return
     */
    boolean validateTopic(String topicId, int status);

    /**
     * Desc:课题选报
     * 
     * @param topicId
     * @param sId     学生ID
     * @return
     */
    boolean signTopic(String topicId, String sId);

    /**
     * Desc:论文上传
     * 
     * @param topicId
     * @param file    论文文件
     * @return
     */
    boolean uoloadPaper(String topicId, MultipartFile file);

    /**
     * Desc:获取课题详情
     * 
     * @param topicId
     * @return
     */
    TopicDetail getTopicDetail(String topicId);
}
