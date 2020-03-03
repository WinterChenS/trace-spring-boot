package com.winterchen.trace.starter.config;


import com.winterchen.trace.starter.factory.TraceContentFactory;
import com.winterchen.trace.starter.filter.TraceFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author purgeyao
 * @since 1.0
 */
@Configuration
public class TraceAutoConfiguration {

    @Bean
    public TraceFilter traceFilter() {
        return new TraceFilter();
    }


    @Bean
    public TraceContentFactory traceContentFactory() {
        return new TraceContentFactory();
    }
}
