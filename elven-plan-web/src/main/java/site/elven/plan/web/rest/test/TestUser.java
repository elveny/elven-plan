/**
 * elven.site Inc.
 * Copyright (c) 2019-2029 All Rights Reserved.
 */
package site.elven.plan.web.rest.test;

import lombok.Data;

import java.util.Date;

/**
 * @Filename TestUser.java
 *
 * @description
 *
 * @Version 1.0
 *
 * @author elven
 * @History
 *
 * <li>Author: elven</li>
 * <li>Date: 2019/12/10 20:51</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
@Data
public class TestUser {
    private long id;
    private String name;
    private float age;
    private Date birthday;
    private float height;
    private float weight;
    private double bodyFatRate;
    /**
     * 0-女；1-男
     */
    private int sex;
}