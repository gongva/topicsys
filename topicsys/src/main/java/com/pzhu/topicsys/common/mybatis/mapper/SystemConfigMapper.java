package com.pzhu.topicsys.common.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pzhu.topicsys.common.mybatis.entity.SystemConfig;
import com.pzhu.topicsys.modules.comm.model.Dict;

public interface SystemConfigMapper {
    int deleteByPrimaryKey(Integer configId);

    int insert(SystemConfig record);

    int insertSelective(SystemConfig record);

    SystemConfig selectByPrimaryKey(Integer configId);

    int updateByPrimaryKeySelective(SystemConfig record);

    int updateByPrimaryKeyWithBLOBs(SystemConfig record);

    int updateByPrimaryKey(SystemConfig record);

    /**
     * desc:获取字典
     * 
     * @param type
     * @return
     */
    List<Dict> getDict(@Param("type") String type);
    
    /**
     * desc:根据Code取Valu
     * 
     * @param code
     * @return
     */
    String getValueByCode(@Param("code") String code);
    
    /**
     * desc:根据Code获取SystemConfig
     * 
     * @param code
     * @return
     */
    SystemConfig selectByCode(@Param("code") String code);
}