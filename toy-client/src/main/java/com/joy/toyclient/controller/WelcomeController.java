package com.joy.toyclient.controller;

import com.joy.toyclient.service.ExternalWelcomeService;
import com.joy.toyclient.service.WelcomeDynamicService;
import com.joy.toyclient.service.WelcomeStaticService;

import com.netflix.hystrix.exception.HystrixBadRequestException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("api/welcome")
public class WelcomeController {

    private final @NotNull WelcomeStaticService welcomeStaticService;
    private final @NotNull WelcomeDynamicService welcomeDynamicService;

    public WelcomeController(WelcomeStaticService welcomeStaticService, WelcomeDynamicService welcomeDynamicService) {
        this.welcomeStaticService = welcomeStaticService;
        this.welcomeDynamicService = welcomeDynamicService;
    }

    @GetMapping("static")
    public String sayHelloAsStatic() {
        return welcomeStaticService.sayHello();
    }

    @GetMapping("dynamic")
    public String sayHelloAsDynamic() {
        return welcomeDynamicService.sayHello();
    }

}
