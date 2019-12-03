/**
 * elven.site Inc.
 * Copyright (c) 2019-2029 All Rights Reserved.
 */
package site.elven.plan.configuration;

import org.springframework.beans.factory.config.YamlMapFactoryBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import site.elven.plan.web.rest.properties.AcmeProperties;

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
}