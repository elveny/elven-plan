/**
 * elven.site Inc.
 * Copyright (c) 2019-2029 All Rights Reserved.
 */
package site.elven.plan.web.service.test;

import org.springframework.stereotype.Service;

/**
 * @Filename FailureAnalyzerService.java
 *
 * @description
 *
 * @Version 1.0
 *
 * @author elven
 * @History
 *
 * <li>Author: elven</li>
 * <li>Date: 2019/12/17 23:14</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
@Service
public class FailureAnalyzerService {
    public FailureAnalyzerService() {
        String string = null;
        // 要想触发FailureAnalyzer，放开以下注释
//        System.out.println(string.equals(null));
    }
}