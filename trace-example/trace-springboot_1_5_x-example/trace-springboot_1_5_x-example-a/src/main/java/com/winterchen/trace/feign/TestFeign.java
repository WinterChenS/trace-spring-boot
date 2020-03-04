package com.winterchen.trace.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "trace-service-a", url = "127.0.0.1:8082")
public interface TestFeign {

    @GetMapping("/test")
    String test();

}
