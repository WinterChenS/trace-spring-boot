package com.winterchen.trace.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    private static final Logger log = LoggerFactory.getLogger(TestService.class);

    public void test() {
        log.info("test 方法执行 {}", MDC.get("X-B3-TraceId"));
        test1();
    }

    private void test1() {
        log.info("test1 方法执行 {}", MDC.get("X-B3-TraceId"));
        new Thread(() -> log.info("test1 方法 线程执行 {}", MDC.get("X-B3-TraceId"))).start();
    }
}
