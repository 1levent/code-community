package com.levent.web.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;
import springfox.documentation.spring.web.plugins.WebMvcRequestHandlerProvider;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

/**
*@Author: guanxinyi
*@CreateTime: 2024-10-17
*@Description: 解决knife4j报错问题
*@Version: 1.0
*/
@Slf4j
@Configuration
public class Knife4jConfig implements WebMvcConfigurer {

    /**
     * 定义了一个Spring Bean后处理器（BeanPostProcessor），
     * 它的目的是在Spring Boot应用程序启动时，
     * 对Springfox（Swagger UI）使用的WebMvcRequestHandlerProvider Bean进行自定义处理。
     * WebMvcRequestHandlerProvider是Spring MVC中用于将URL路径映射到控制器处理方法的组件。
     * Springfox利用这个组件来生成API文档
     * 确保Springfox能够正确地处理Spring Boot 2.6及以上版本的路径匹配策略变化，
     * 通过自定义WebMvcRequestHandlerProvider Bean来避免可能的兼容性问题
     * @return
     */
    @Bean
    public static BeanPostProcessor springfoxHandlerProviderBeanPostProcessor() {
        return new BeanPostProcessor() {

            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if (bean instanceof WebMvcRequestHandlerProvider) {
                    customizeSpringfoxHandlerMappings(getHandlerMappings(bean));
                }
                return bean;
            }

            private <T extends RequestMappingInfoHandlerMapping> void customizeSpringfoxHandlerMappings(List<T> mappings) {
                List<T> copy = mappings.stream()
                        .filter(mapping -> mapping.getPatternParser() == null)
                        .collect(Collectors.toList());
                mappings.clear();
                mappings.addAll(copy);
            }

            @SuppressWarnings("unchecked")
            private List<RequestMappingInfoHandlerMapping> getHandlerMappings(Object bean) {
                try {
                    Field field = ReflectionUtils.findField(bean.getClass(), "handlerMappings");
                    field.setAccessible(true);
                    return (List<RequestMappingInfoHandlerMapping>) field.get(bean);
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    throw new IllegalStateException(e);
                }
            }
        };
    }
}
