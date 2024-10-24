package com.levent.web.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: guanxinyi
 * @CreateTime: 2024-10-09
 * @Description: 全局配置类
 * @Version: 1.0
 */
@Data
@ConfigurationProperties(prefix = "view.site")
@Component
public class GlobalViewConfig {
    private String host;

    private String websiteName;

    /**
     * 首次登录的欢迎信息
     */
    private String welcomeInfo;
}
