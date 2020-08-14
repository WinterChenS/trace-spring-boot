package com.winterchen.trace.starter.config;

import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import com.winterchen.trace.starter.instrument.hystrix.TraceHystrixConcurrencyStrategy;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(value = {HystrixConcurrencyStrategy.class})
public class HystrixAutoConfiguration {

    @Bean
    public TraceHystrixConcurrencyStrategy traceHystrixConcurrencyStrategy() {
        return new TraceHystrixConcurrencyStrategy();
    }
}
