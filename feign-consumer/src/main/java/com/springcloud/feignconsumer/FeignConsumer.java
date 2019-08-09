package com.springcloud.feignconsumer;

import com.springcloud.service.api.HelloServiceApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author zpf
 * @date 2019/8/9 13:35
 */
@FeignClient("service1")
public interface FeignConsumer extends HelloServiceApi {
}