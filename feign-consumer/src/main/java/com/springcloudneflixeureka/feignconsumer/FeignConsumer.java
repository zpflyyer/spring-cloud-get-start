package com.springcloudneflixeureka.feignconsumer;

import com.springcloudneflixeureka.servicedefination.HelloServiceApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author zpf
 * @date 2019/8/9 13:35
 */
@FeignClient("service1")
public interface FeignConsumer extends HelloServiceApi {
}