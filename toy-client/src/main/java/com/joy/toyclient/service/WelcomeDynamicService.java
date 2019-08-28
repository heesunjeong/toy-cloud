package com.joy.toyclient.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@RefreshScope
@Service
public class WelcomeDynamicService {

    @Value("${toystory.say.hello}")
    private String hello;

    public String sayHello() {
        return hello;
    }
}
