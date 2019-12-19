/**
 * elven.site Inc.
 * Copyright (c) 2019-2029 All Rights Reserved.
 */
package site.elven.plan.web.jersey;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * @Filename JerseyConfig.java
 *
 * @description
 *
 * @Version 1.0
 *
 * @author elven
 * @History
 *
 * <li>Author: elven</li>
 * <li>Date: 2019/12/19 20:23</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
@Deprecated // 因为会影响正常的http请求
//@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig(){
        register(Endpoint.class);
    }
}