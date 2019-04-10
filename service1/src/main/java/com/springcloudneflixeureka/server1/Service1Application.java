package com.springcloudneflixeureka.server1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.InstanceInfoFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
@Slf4j
public class Service1Application {

    @RequestMapping("/hello")
    public String helloController(){
        log.info("hello service instance get consumed");
        return "hello!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Service1Application.class, args);
    }
}
