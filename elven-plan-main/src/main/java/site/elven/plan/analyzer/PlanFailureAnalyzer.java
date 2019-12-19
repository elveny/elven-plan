package site.elven.plan.analyzer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.diagnostics.FailureAnalysis;
import org.springframework.boot.diagnostics.FailureAnalyzer;

/**
 * Demo class
 *
 * @author wuqs
 * @date 2016/10/31
 */
public class PlanFailureAnalyzer implements FailureAnalyzer {
    private final static Logger logger = LoggerFactory.getLogger(PlanFailureAnalyzer.class);
    @Override
    public FailureAnalysis analyze(Throwable failure) {
        logger.error("异常信息 failure: {}", failure.getMessage());
        return new FailureAnalysis("异常信息: "+failure.getMessage(), "正确处理问题", failure);
    }
}
