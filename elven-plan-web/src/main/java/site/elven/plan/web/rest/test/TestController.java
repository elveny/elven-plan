/**
 * elven.tech Inc.
 * Copyright (c) 2017-2026 All Rights Reserved.
 */
package site.elven.plan.web.rest.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.YamlMapFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.elven.plan.web.properties.AcmeProperties;
import site.elven.plan.web.provider.ApplicationContextProvider;
import site.elven.plan.web.provider.ExitCodeGeneratorProvider;
import site.elven.plan.web.rest.BaseController;

import java.util.Date;

/**
 * 公用测试Controller
 * @Filename TestController.java
 *
 * @description
 *
 * @Version 1.0
 *
 * @author elven
 * @History
 *
 * <li>Author: elven</li>
 * <li>Date: 17-2-21 下午11:28</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
@RestController
@RequestMapping("/web/rest/test")
public class TestController extends BaseController {

    @Value("${info.contact.email}")
    private String email;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ApplicationContextProvider applicationContextProvider;

    @Autowired
    private ExitCodeGeneratorProvider exitCodeGeneratorProvider;

    @Autowired
    private YamlMapFactoryBean yamlMapFactoryBean;

    @Autowired
    private AcmeProperties acmeProperties;

    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping("hello")
    public String hello() {
        logger.info("start hello...开始“你好”。。。");
        return "hello world!!!您好，世界！！！";
    }

    @RequestMapping("env-order")
    public String envOrder() {
        logger.info("env-order email = {}", email);
        return "email = " + email;
    }

    @RequestMapping("yaml")
    public String yaml() {
        logger.info("yaml = {}", yamlMapFactoryBean.getObject());
        return "yaml = " + yamlMapFactoryBean.getObject();
    }

    @RequestMapping("acme")
    public String acme() throws JsonProcessingException {
        logger.info("acmeProperties = {}", objectMapper.writeValueAsString(acmeProperties));
        logger.info("acmeProperties.getRemoteAddress() = {}", acmeProperties.getRemoteAddress());
        return "acmeProperties.getRemoteAddress() = " + acmeProperties.getRemoteAddress();
    }


    @RequestMapping("log")
    public String log() {
        logger.info("log level log");
        logger.debug("log level debug");
        return "success";
    }

    @RequestMapping("exit")
    public String exit(){
        logger.info("applicationContext = {}", applicationContext);
        logger.info("applicationContextProvider.getApplicationContext() = {}", applicationContextProvider.getApplicationContext());
        System.exit(SpringApplication.exit(applicationContextProvider.getApplicationContext(), exitCodeGeneratorProvider));
        return "success";
    }

    @RequestMapping("user")
    public TestUser user(@RequestBody TestUser testUser){
        testUser.setId(1L);
        testUser.setName("埃尔文");
        testUser.setAge(35.5d);
        testUser.setBirthDate(new Date(84, 7, 7));

        logger.info("user : {}", testUser);
        return testUser;
    }

}