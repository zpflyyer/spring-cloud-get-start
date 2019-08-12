package com.springcloud.service.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zpf
 * @date 2019/8/9 15:52
 */
@RequestMapping("/simple")
public interface HelloServiceApi {
    @RequestMapping("/hello")
    String hello(@RequestParam String name);
}
