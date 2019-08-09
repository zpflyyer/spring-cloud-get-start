package com.springcloudneflixeureka.consumer1;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableLBRestTemplate
@EnableCircuitBreaker
public class Consumer1Application {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/ribbon-consumer")
    @HystrixCommand(fallbackMethod = "defaultFallback")
    public String helloConsumer(@RequestParam String name) {
        return restTemplate.getForObject("http://service1/hello-service/hello" + "?" + "name=" + name, String.class);
    }

    private String defaultFallback(String name) {
        return "service is not available now!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Consumer1Application.class, args);
    }
}
