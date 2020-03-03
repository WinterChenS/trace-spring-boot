package com.winterchen.trace.starter.config;

import com.netflix.hystrix.strategy.HystrixPlugins;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import com.winterchen.trace.starter.instrument.hystrix.TraceHystrixConcurrencyStrategy;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@ConditionalOnClass(value = {HystrixConcurrencyStrategy.class})
public class HystrixAutoConfiguration {

    @PostConstruct
    public void init() {
        HystrixPlugins.getInstance().registerConcurrencyStrategy(new TraceHystrixConcurrencyStrategy());
    }
}
