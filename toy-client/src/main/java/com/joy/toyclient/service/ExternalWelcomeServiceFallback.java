package com.joy.toyclient.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ExternalWelcomeServiceFallback implements ExternalWelcomeService {
    @Override
    public String sayHello() {
        log.debug("Fallback called");
        return "Hello. This is Fallback Greeting.";
    }
}
