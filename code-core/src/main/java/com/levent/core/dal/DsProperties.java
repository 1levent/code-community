package com.levent.dal;

import lombok.Data;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author: guanxinyi
 * @CreateTime: 2024-10-10
 * @Description: 多数据源的配置加载
 * @Version: 1.0
 */
@Data
@ConfigurationProperties(prefix = DsProperties.DS_PREFIX)
@Component
public class DsProperties {
    public static final String DS_PREFIX = "spring.dynamic";
    /**
     * 默认数据源
     */
    private String primary;

    /**
     * 多数据源配置
     */
    private Map<String, DataSourceProperties> datasource;
}
