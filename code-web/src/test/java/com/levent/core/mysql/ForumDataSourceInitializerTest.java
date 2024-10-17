package com.levent.core.mysql;

import com.levent.web.BasicTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;
import java.sql.SQLException;

@Slf4j
public class ForumDataSourceInitializerTest extends BasicTest {
    @Value("classpath:liquibase/data/init_schema_221209.sql")
    private Resource schemaSql;
    @Value("classpath:liquibase/data/init_data_221209.sql")
    private Resource initData;

    @Test
    public void dataSourceInitializer() throws SQLException {
        DataSource dataSource = createCustomDataSource();
        log.info(dataSource.getConnection().getMetaData().getURL());

        final DataSourceInitializer initializer = new DataSourceInitializer();
        // 设置数据源
        initializer.setDataSource(dataSource);
        initializer.setEnabled(true);

        final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(schemaSql);
        populator.addScript(initData);
        initializer.setDatabasePopulator(populator);
        initializer.afterPropertiesSet();
    }

    private DataSource createCustomDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/xinyi");
        dataSource.setUsername("root");
        dataSource.setPassword("zkzc0722@Gxy");
        return dataSource;
    }
}