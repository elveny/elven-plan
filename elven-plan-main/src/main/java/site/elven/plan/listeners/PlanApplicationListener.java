package site.elven.plan.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.*;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * Demo class
 *
 * @author wuqs
 * @date 2019/09/31
 */
public class PlanApplicationListener implements ApplicationListener {
    private final static Logger logger = LoggerFactory.getLogger(PlanApplicationListener.class);
    @Override
    public void onApplicationEvent(ApplicationEvent event) {

        if(event instanceof ApplicationStartingEvent){
            logger.info("ApplicationStartingEvent");
        }

        if(event instanceof ApplicationEnvironmentPreparedEvent){
            logger.info("ApplicationEnvironmentPreparedEvent");
        }

        if(event instanceof ApplicationPreparedEvent){
            logger.info("ApplicationPreparedEvent");
        }

        if(event instanceof ApplicationStartedEvent){
            logger.info("ApplicationStartedEvent");
        }

        if(event instanceof ApplicationReadyEvent){
            logger.info("ApplicationReadyEvent");
        }

        if(event instanceof ApplicationFailedEvent){
            logger.info("ApplicationFailedEvent");
        }

    }
}
