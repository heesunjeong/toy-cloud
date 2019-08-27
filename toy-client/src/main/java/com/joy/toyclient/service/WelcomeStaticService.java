package com.joy.toyclient.service;

import com.netflix.hystrix.exception.HystrixBadRequestException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WelcomeStaticService {

    private final ExternalWelcomeService externalWelcomeService;

    public WelcomeStaticService(ExternalWelcomeService externalWelcomeService) {
        this.externalWelcomeService = externalWelcomeService;
    }

    @Value("${toystory.say.hello}")
    private String hello;

    public String sayHello() {
        return hello;
    }
}
