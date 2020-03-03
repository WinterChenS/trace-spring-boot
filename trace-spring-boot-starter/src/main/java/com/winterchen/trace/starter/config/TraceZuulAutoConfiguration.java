package com.winterchen.trace.starter.config;

import com.netflix.zuul.ZuulFilter;
import com.winterchen.trace.starter.factory.TraceContentFactory;
import com.winterchen.trace.starter.instrument.zuul.TracePreZuulFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author purgeyao
 * @since 1.0
 */
@Configuration
@ConditionalOnWebApplication
@ConditionalOnClass({ZuulFilter.class, TraceContentFactory.class})
public class TraceZuulAutoConfiguration {

    @Bean
    public TracePreZuulFilter traceZuulFilter(TraceContentFactory traceContentFactory){
        return new TracePreZuulFilter(traceContentFactory);
    }
}
