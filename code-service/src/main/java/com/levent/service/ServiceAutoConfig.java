package com.levent.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: guanxinyi
 * @CreateTime: 2024-10-17
 * @Description: 服务自动配置类
 * @Version: 1.0
 */
@Configuration
@ComponentScan("com.levent.service")
@MapperScan("com.levent.service.demo.repository.mapper")
public class ServiceAutoConfig {
}
