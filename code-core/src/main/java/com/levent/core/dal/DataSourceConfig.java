package com.levent.core.dal;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import lombok.extern.slf4j.Slf4j;
import com.google.common.collect.Maps;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.util.CollectionUtils;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @Author: guanxinyi
 * @CreateTime: 2024-10-10
 * @Description: 多数据源
 * @Version: 1.0
 */
@Slf4j
@Configuration
@ConditionalOnProperty(prefix = "spring.dynamic", name = "primary")
@EnableConfigurationProperties(DsProperties.class)
public class DataSourceConfig {

    private Environment environment;

    public DataSourceConfig(Environment environment) {
        this.environment = environment;
        log.info("动态数据源初始化!");
    }

    @Bean
    public DsAspect dsAspect() {
        return new DsAspect();
    }

    @Bean
    public SqlStateInterceptor sqlStateInterceptor() {
        return new SqlStateInterceptor();
    }

    /**
     * 整合主从数据源
     * @param dsProperties
     * @return
     */
    @Bean
    @Primary
    public DataSource dataSource(DsProperties dsProperties){
        Map<Object,Object> targetDataSources = Maps.newHashMapWithExpectedSize(dsProperties.getDatasource().size());
        dsProperties.getDatasource().forEach((k,v)->targetDataSources.put(k.toUpperCase(),initDataSource(k,v)));

        if (CollectionUtils.isEmpty(targetDataSources)) {
            throw new IllegalStateException("多数据源配置，请以 spring.dynamic 开头");
        }
        MyRoutingDataSource dataSource = new MyRoutingDataSource();

        Object key = dsProperties.getPrimary().toUpperCase();
        if(!targetDataSources.containsKey(key)){
            if(targetDataSources.containsKey(MasterSlaveDsEnum.MASTER.name())){
                //当没有配置默认数据库时，配置了主库，则默认使用主库
                key = MasterSlaveDsEnum.MASTER.name();
            }else{
                key = targetDataSources.keySet().iterator().next();
            }
        }
        log.info("动态数据源，默认启用为： " + key);
        dataSource.setDefaultTargetDataSource(targetDataSources.get(key));
        dataSource.setTargetDataSources(targetDataSources);
        return dataSource;
    }

    /**
     * 初始化数据源
     * @param prefix
     * @param properties
     * @return
     */
    public DataSource initDataSource(String prefix, DataSourceProperties properties){
        //不包含druid包
        if(!DruidCheckUtil.hasDuridPkg()){
            log.info("实例化HikarDataSource: {}", prefix);
            return properties.initializeDataSourceBuilder().build();
        }

        if (properties.getType() == null || !properties.getType().isAssignableFrom(DruidDataSource.class)) {
            log.info("实例化HikarDataSource: {}", prefix);
            return properties.initializeDataSourceBuilder().build();
        }

        log.info("实例化DruidDataSource: {}", prefix);
        // fixme 知识点：手动将配置赋值到实例中的方式
        return Binder.get(environment).bindOrCreate(DsProperties.DS_PREFIX + ".datasource." + prefix, DruidDataSource.class);
    }

    /**
     * 在数据源实例化之后进行创建
     *
     * @return
     */
    @Bean
    @ConditionalOnExpression(value = "T(com.levent.core.dal.DruidCheckUtil).hasDuridPkg()")
    public ServletRegistrationBean<?> druidStatViewServlet() {
        //先配置管理后台的servLet，访问的入口为/druid/
        ServletRegistrationBean<?> servletRegistrationBean = new ServletRegistrationBean<>(
                new StatViewServlet(), "/druid/*");
        // IP白名单 (没有配置或者为空，则允许所有访问)
        servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
        // IP黑名单 (存在共同时，deny优先于allow)
        servletRegistrationBean.addInitParameter("deny", "");
        servletRegistrationBean.addInitParameter("loginUsername", "admin");
        servletRegistrationBean.addInitParameter("loginPassword", "admin");
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        log.info("开启druid数据源监控面板");
        return servletRegistrationBean;
    }

}
