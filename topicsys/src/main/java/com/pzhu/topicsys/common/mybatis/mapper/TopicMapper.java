package com.pzhu.topicsys.common.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.github.pagehelper.Page;
import com.pzhu.topicsys.common.mybatis.entity.Topic;
import com.pzhu.topicsys.modules.topic.model.TopicDetail;
import com.pzhu.topicsys.modules.topic.model.TopicList;

public interface TopicMapper {
    int deleteByPrimaryKey(String topicId);

    int insert(Topic record);

    int insertSelective(Topic record);

    Topic selectByPrimaryKey(String topicId);

    int updateByPrimaryKeySelective(Topic record);

    int updateByPrimaryKeyWithBLOBs(Topic record);

    int updateByPrimaryKey(Topic record);

    /**
     * Desc:根据学生的UserId获取课题信息
     * 
     * @param userId
     * @return
     */
    Topic selectByUserId(@Param("sId") String sId);

    /**
     * Desc:查询课题
     * 
     * @param tName
     * @param rowBounds
     * @return
     */
    Page<TopicList> findTopics(@Param("tName") String tName, RowBounds rowBounds);

    /**
     * Desc:查询导师创建的课题
     * 
     * @param tId
     * @param tName
     * @param rowBounds
     * @return
     */
    Page<TopicList> findTopicsByTid(@Param("tId") String tId, @Param("tName") String tName, RowBounds rowBounds);

    /**
     * Desc:查询学生选报的课题
     * 
     * @param sId
     * @param tName
     * @param rowBounds
     * @return
     */
    Page<TopicList> findTopicsBySid(@Param("sId") String sId, @Param("tName") String tName, RowBounds rowBounds);

    /**
     * Desc:查询学生所在院系所有导师的课题
     * 
     * @param sId
     * @param tName
     * @param rowBounds
     * @return
     */
    Page<TopicList> findTopicsBySDepartment(@Param("sId") String sId, @Param("tName") String tName,
            RowBounds rowBounds);

    /**
     * Desc:根据topic_name查Topic
     * 
     * @param name
     * @return
     */
    Topic getTopicByName(@Param("name") String name);

    /**
     * Desc:根据topic_id查详情
     * 
     * @param topicId
     * @return
     */
    TopicDetail getTopicDetail(@Param("topicId") String topicId);
}