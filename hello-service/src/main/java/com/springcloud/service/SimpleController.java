package com.springcloud.service;

import com.springcloud.service.api.HelloServiceApi;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author zpf
 * @date 2019/8/15 13:39
 */
@RestController
@RefreshScope
@Slf4j
public class SimpleController implements HelloServiceApi {

    @Value("${msg}")
    private String msg;

    @Override
    @SneakyThrows
    public String hello(@RequestParam String name) {
        int sleepTime = new Random().nextInt(3000);
        Thread.sleep(sleepTime);
        log.info("sleepTime:{}", sleepTime);
        log.info("hello service instance get consumed");
        return msg + " " + name;
    }
}
