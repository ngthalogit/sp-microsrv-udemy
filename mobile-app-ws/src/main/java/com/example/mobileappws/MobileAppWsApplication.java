package com.example.mobileappws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@RequestMapping("/mobi-app-home")
public class MobileAppWsApplication {
    @Autowired
    public Environment env;
    public static void main(String[] args) {
        SpringApplication.run(MobileAppWsApplication.class, args);
    }
    @GetMapping()
    public String home() {
        return "Hello ! This is mobi app with port = " + env.getProperty("local.server.port");
    }
}
