package com.pzhu.topicsys.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 配置连接池，配置Mybatis持久层
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.pzhu.topicsys.common.mybatis.mapper")
public class DataSourceConfiguration {

}
