package com.levent.core;

import com.levent.core.cache.RedisClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Author: guanxinyi
 * @CreateTime: 2024-10-12
 * @Description: 核心自动配置类
 * @Version: 1.0
 */
@Configuration
@ComponentScan("com.levent.core")
public class ForumCoreAutoConfig {

    public ForumCoreAutoConfig(RedisTemplate<String, String> redisTemplate) {
        RedisClient.register(redisTemplate);
    }
}
