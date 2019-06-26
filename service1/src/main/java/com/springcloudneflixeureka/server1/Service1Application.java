package com.springcloudneflixeureka.server1;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@SpringCloudApplication
@RestController
@Slf4j
public class Service1Application {

    @RequestMapping("/hello")
    @SneakyThrows
    public String helloController() {
        int sleepTime = new Random().nextInt(3000);
        Thread.sleep(sleepTime);
        log.info("sleepTime:{}", sleepTime);
        log.info("hello service instance get consumed");
        return "hello!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Service1Application.class, args);
    }
}
