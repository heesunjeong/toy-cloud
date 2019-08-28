package com.joy.toyclient.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "TOY-API", fallback = ExternalWelcomeServiceFallback.class)
public interface ExternalWelcomeService {

    @GetMapping(path = "api/welcome/static")
    String sayHello();
}
