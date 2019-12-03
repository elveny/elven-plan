/**
 * elven.site Inc.
 * Copyright (c) 2019-2029 All Rights Reserved.
 */
package site.elven.plan.web.rest.provider;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;

/**
 * @Filename ExitCodeGeneratorProvider.java
 *
 * @description
 *
 * @Version 1.0
 *
 * @author elven
 * @History
 *
 * <li>Author: elven</li>
 * <li>Date: 2019/12/3 21:43</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
@Component
public class ExitCodeGeneratorProvider implements ExitCodeGenerator {
    @Override
    public int getExitCode() {
        return 4444;
    }
}