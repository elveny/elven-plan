/**
 * elven.site Inc.
 * Copyright (c) 2019-2029 All Rights Reserved.
 */
package site.elven.plan.configuration;

import org.springframework.beans.factory.config.YamlMapFactoryBean;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import site.elven.plan.web.converter.FastJsonHttpMessageConverter;
import site.elven.plan.web.properties.AcmeProperties;

/**
 * @Filename CustomComponent.java
 *
 * @description
 *
 * @Version 1.0
 *
 * @author elven
 * @History
 *
 * <li>Author: elven</li>
 * <li>Date: 2019/9/25 23:11</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
@Configuration
@EnableConfigurationProperties(AcmeProperties.class)
public class SomeConfiguration {
    @Bean
    public YamlMapFactoryBean yamlMapFactoryBean(){
        return new YamlMapFactoryBean();
    }

    @Bean
    public HttpMessageConverters customConverters(){
        FastJsonHttpMessageConverter fastjsonHttpMessageConverter = new FastJsonHttpMessageConverter();

        return new HttpMessageConverters(fastjsonHttpMessageConverter);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/web/rest/cors/**")
                        .allowedHeaders("*")
                        .allowCredentials(true)
                        .allowedMethods("*")
                        .allowedOrigins("*")
//                        .exposedHeaders("*")
                        .maxAge(1000L)
                        ;
            }
        };
    }

}