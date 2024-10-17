package com.levent;

import com.levent.config.GlobalViewConfig;
import com.levent.util.SocketUtil;
import com.levent.util.SpringUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: guanxinyi
 * @CreateTime: 2024-09-30
 * @Description: 启动类
 * @Version: 1.0
 */

@Slf4j
@EnableAsync
@EnableScheduling
@EnableCaching
@ServletComponentScan
@SpringBootApplication
public class QuickStart implements WebMvcConfigurer, ApplicationRunner {
    @Value("${server.port:8080}")
    private Integer webPort;
    public static void main(String[] args) {
        SpringApplication.run(QuickStart.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 应用启动之后执行
        GlobalViewConfig config = SpringUtil.getBean(GlobalViewConfig.class);
        if (webPort != null) {
            config.setHost("http://127.0.0.1:" + webPort);
        }
        log.info("启动成功，点击进入首页: {}", config.getHost());
    }
    @Bean
    @ConditionalOnExpression(value = "#{'dev'.equals(environment.getProperty('env.name'))}")
    public TomcatConnectorCustomizer customServerPortTomcatConnectorCustomizer() {
        //首先判断 8080 默认端口是否可用；若可用，则直接用，否则选择一个可用的端口号启动
        int port = SocketUtil.findAvailableTcpPort(8080, 8090, webPort);
        if(webPort!=port){
            log.info("默认端口号：{}被占用，随机启用端口号：{}",webPort,port);
            webPort = port;
        }
        return connector -> connector.setPort(port);
    }
}
