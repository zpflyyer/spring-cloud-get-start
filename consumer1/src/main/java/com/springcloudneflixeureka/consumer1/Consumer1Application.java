package com.springcloudneflixeureka.consumer1;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringCloudApplication
@RestController
@EnableLBRestTemplate
public class Consumer1Application {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/ribbon-consumer")
    @HystrixCommand(fallbackMethod = "defaultFallback")
    public String helloConsumer() {
        return restTemplate.getForEntity("http://service1/hello", String.class).getBody();
    }

    private String defaultFallback() {
        return "service is not available now!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Consumer1Application.class, args);
    }
}
