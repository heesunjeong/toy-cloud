package com.joy.toyclient.controller;

import com.joy.toyclient.service.ExternalWelcomeService;
import com.joy.toyclient.service.WelcomeDynamicService;
import com.joy.toyclient.service.WelcomeStaticService;

import com.netflix.hystrix.exception.HystrixBadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@RestController
@RequestMapping("api/welcome")
public class WelcomeController {

    @Value("${server.port}")
    private String port;

    private final @NotNull WelcomeStaticService welcomeStaticService;
    private final @NotNull WelcomeDynamicService welcomeDynamicService;

    public WelcomeController(WelcomeStaticService welcomeStaticService, WelcomeDynamicService welcomeDynamicService) {
        this.welcomeStaticService = welcomeStaticService;
        this.welcomeDynamicService = welcomeDynamicService;
    }

    @GetMapping("static")
    public String sayHelloAsStatic() throws UnknownHostException {
        log.info("static. IP address: {}, port: {}", InetAddress.getLocalHost().getHostAddress(), port);
        return welcomeStaticService.sayHello();
    }

    @GetMapping("dynamic")
    public String sayHelloAsDynamic() throws UnknownHostException {
        log.info("dynamic. IP address: {}, port: {}", InetAddress.getLocalHost().getHostAddress(), port);
        return welcomeDynamicService.sayHello();
    }

    // fallback 하지 않도록 에러 발생
    @GetMapping("exc")
    public String sayHelloAsExc() throws UnknownHostException {
        log.info("exc. IP address: {}, port: {}", InetAddress.getLocalHost().getHostAddress(), port);
        return welcomeStaticService.sayHi();
    }

    // feign으로 eureka + ribbon 연동하여 사용하기
    @GetMapping("feign")
    public String sayHi() throws UnknownHostException {
        log.info("feign. IP address: {}, port: {}", InetAddress.getLocalHost().getHostAddress(), port);
        return welcomeStaticService.sayHola();
    }

}
