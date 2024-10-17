package com.levent.core.dal;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.annotation.Nullable;

/**
 * @Author: guanxinyi
 * @CreateTime: 2024-10-10
 * @Description: 数据源
 * @Version: 1.0
 */
public class MyRoutingDataSource extends AbstractRoutingDataSource {
    @Nullable
    @Override
    protected Object determineCurrentLookupKey() {
        return DsContextHolder.get();
    }
}
