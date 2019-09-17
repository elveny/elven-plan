/**
 * elven.site Inc.
 * Copyright (c) 2018-2026 All Rights Reserved.
 */
package site.elven.plan.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import site.elven.plan.web.rest.test.TestController;

/**
 * @author qiusheng.wu
 * @Filename BaseController.java
 * @description
 * @Version 1.0
 * @History <li>Author: qiusheng.wu</li>
 * <li>Date: 2018/4/18 20:47</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class BaseController {
    /** 日志记录器 **/
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * home
     * @return
     */
    @RequestMapping()
    public String home(){
        String className = this.getClass().getSimpleName();
        logger.info("access {}'s home", className);
        return className+":home";
    }
}