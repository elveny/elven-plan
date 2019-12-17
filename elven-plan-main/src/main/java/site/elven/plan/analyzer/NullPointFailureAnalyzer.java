/**
 * elven.site Inc.
 * Copyright (c) 2019-2029 All Rights Reserved.
 */
package site.elven.plan.analyzer;

import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;

/**
 * @Filename NullPointFailureAnalyzer.java
 *
 * @description
 *
 * @Version 1.0
 *
 * @author elven
 * @History
 *
 * <li>Author: elven</li>
 * <li>Date: 2019/12/17 22:51</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class NullPointFailureAnalyzer extends AbstractFailureAnalyzer<NullPointerException> {
    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, NullPointerException cause) {
        return new FailureAnalysis(cause.getMessage(), "请检查空指针", cause);
    }
}