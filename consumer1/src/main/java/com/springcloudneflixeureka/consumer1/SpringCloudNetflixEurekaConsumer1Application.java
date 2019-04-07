package com.springcloudneflixeureka.consumer1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
@EnableLBRestTemplate
public class SpringCloudNetflixEurekaConsumer1Application {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/ribbon-consumer")
    public String helloConsumer(){
        return restTemplate.getForEntity("http://service1/hello", String.class).getBody();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudNetflixEurekaConsumer1Application.class, args);
    }
}
