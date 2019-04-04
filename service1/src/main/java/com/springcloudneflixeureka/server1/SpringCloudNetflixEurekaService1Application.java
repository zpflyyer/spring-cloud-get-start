package com.springcloudneflixeureka.server1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class SpringCloudNetflixEurekaService1Application {

    @RequestMapping("/hello")
    public String helloController(){
        return "hello!";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudNetflixEurekaService1Application.class, args);
    }
}
