package site.elven.plan.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
/**
 * @Filename CustomComponent.java
 *
 * @description
 *
 * @Version 1.0
 *
 * @author elven
 * @History
 *
 * <li>Author: elven</li>
 * <li>Date: 2019/9/25 23:11</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
@Component
@Slf4j
public class PlanApplicationArgument {

    @Autowired
    public PlanApplicationArgument(ApplicationArguments args){
        boolean debug = args.containsOption("debug");
        log.info("debug: {}", debug);
        List<String> nonOptionArgs = args.getNonOptionArgs();
        log.info("nonOptionArgs: {}", nonOptionArgs);

        String[] sourceArgs = args.getSourceArgs();
        log.info("sourceArgs: {}", Arrays.asList(sourceArgs));

        Set<String> optionNames = args.getOptionNames();
        optionNames.forEach(log::info);

        optionNames.forEach(optionName->log.info("args.getOptionValues(optionName): {}:{}", optionName, args.getOptionValues(optionName)));

    }
}
