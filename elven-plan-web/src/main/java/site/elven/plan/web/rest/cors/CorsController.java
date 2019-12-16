/**
 * elven.site Inc.
 * Copyright (c) 2019-2029 All Rights Reserved.
 */
package site.elven.plan.web.rest.cors;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Filename CorsController.java
 *
 * @description
 *
 * @Version 1.0
 *
 * @author elven
 * @History
 *
 * <li>Author: elven</li>
 * <li>Date: 2019/12/16 22:00</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
@RestController
@RequestMapping("/web/rest/cors")
public class CorsController {

    @RequestMapping("/test1")
    public String test1(){
        return "cors test1 success";
    }
}