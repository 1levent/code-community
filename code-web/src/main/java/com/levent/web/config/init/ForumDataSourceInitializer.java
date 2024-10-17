package com.levent.web.config.init;

import org.springframework.beans.factory.annotation.Value;

/**
 * @Author: guanxinyi
 * @CreateTime: 2024-10-09
 * @Description: 数据库初始化
 * @Version: 1.0
 */
public class DataSourceInitializer {

    @Value("${database.name}")
    private String database;

    @Value("${spring.liquibase.enabled}")
    private Boolean liquibaseEnabled;

    @Value("${spring.liquibase.change-log}")
    private String liquibaseChangeLog;

    
}
