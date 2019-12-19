/**
 * elven.site Inc.
 * Copyright (c) 2019-2029 All Rights Reserved.
 */
package site.elven.plan.web.jersey;

import lombok.Data;

/**
 * @Filename TestObject.java
 *
 * @description
 *
 * @Version 1.0
 *
 * @author elven
 * @History
 *
 * <li>Author: elven</li>
 * <li>Date: 2019/12/19 20:59</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
@Deprecated // 因为会影响正常的http请求
@Data
public class TestObject {
    private int id;
    private String name;
}