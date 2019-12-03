/**
 * elven.tech Inc.
 * Copyright (c) 2017-2026 All Rights Reserved.
 */
package site.elven.plan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Filename Application.java
 *
 * @description
 *
 * @Version 1.0
 *
 * @author elven
 * @History
 *
 * <li>Author: elven</li>
 * <li>Date: 17-2-21 下午11:04</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
@SpringBootApplication
public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {
        logger.info("start run application...");
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.setAddCommandLineProperties(true);
        springApplication.setAdditionalProfiles("prod");
        springApplication.run(args);
        logger.info("...application run completely!!!");
    }
}