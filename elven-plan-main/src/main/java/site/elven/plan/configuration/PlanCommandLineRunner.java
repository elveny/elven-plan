package site.elven.plan.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
public class PlanCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
            log.info("{}", Arrays.asList(args));
    }
}
