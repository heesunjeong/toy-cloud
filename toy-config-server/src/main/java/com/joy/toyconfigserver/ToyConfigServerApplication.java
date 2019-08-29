package com.joy.toyconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ToyConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToyConfigServerApplication.class, args);
    }

}
