/**
 * elven.site Inc.
 * Copyright (c) 2019-2029 All Rights Reserved.
 */
package site.elven.plan.web.jersey;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @Filename Endpoint.java
 *
 * @description
 *
 * @Version 1.0
 *
 * @author elven
 * @History
 *
 * <li>Author: elven</li>
 * <li>Date: 2019/12/19 20:41</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
@Deprecated // 因为会影响正常的http请求
@Component
@Path("/jersey/hello")
public class Endpoint {

    @GET
    @Path("/msg")
    public String message(){
        return "hello jersey";
    }

    @GET
    @Path("/test")
    public String test(){
        return "hello test";
    }

    @GET
    @Path("/obj")
    public TestObject object(){
        // todo 报错 MessageBodyWriter not found for media type=text/xml, type=class site.elven.plan.web.jersey.TestObject, genericType=class site.elven.plan.web.jersey.TestObject.
        TestObject object = new TestObject();
        object.setId(122333);
        object.setName("object ttttttttttt");
        return object;
    }
}