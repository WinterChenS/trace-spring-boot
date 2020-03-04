package com.winterchen.trace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class TraceSpringboot15XExampleAApplication {

    public static void main(String[] args) {
        SpringApplication.run(TraceSpringboot15XExampleAApplication.class, args);
    }

}
