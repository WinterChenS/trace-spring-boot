package com.winterchen.trace.starter.config;

import com.winterchen.trace.starter.factory.TraceContentFactory;
import com.winterchen.trace.starter.instrument.resttemplate.RestTemplatePostProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author purgeyao
 * @since 1.0
 */
@Configuration
@ConditionalOnClass({RestTemplate.class, TraceContentFactory.class})
public class TraceRestTemplateConfiguration {

    @Bean
    public RestTemplatePostProcessor restTemplatePostProcessor(TraceContentFactory traceContentFactory) {
        return new RestTemplatePostProcessor(traceContentFactory);
    }
}
