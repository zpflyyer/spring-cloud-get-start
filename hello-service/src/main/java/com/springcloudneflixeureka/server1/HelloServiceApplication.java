package com.springcloudneflixeureka.server1;

import com.springcloudneflixeureka.servicedefination.HelloServiceApi;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@Slf4j
public class HelloServiceApplication implements HelloServiceApi {

    @Override
    @SneakyThrows
    public String hello(@RequestParam String name) {
        int sleepTime = new Random().nextInt(3000);
        Thread.sleep(sleepTime);
        log.info("sleepTime:{}", sleepTime);
        log.info("hello service instance get consumed");
        return "hello! " + name;
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloServiceApplication.class, args);
    }
}
