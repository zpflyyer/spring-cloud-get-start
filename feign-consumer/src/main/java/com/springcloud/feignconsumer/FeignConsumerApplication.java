package com.springcloud.feignconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zpf
 * @date 2019/8/9 10:50
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController

@EnableFeignClients
public class FeignConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignConsumerApplication.class, args);
    }

    @Autowired
    private FeignConsumer feignConsumer;

    @RequestMapping("feign-consumer")
    public String feignConsumer(@RequestParam String name){
        return feignConsumer.hello(name);
    }
}
