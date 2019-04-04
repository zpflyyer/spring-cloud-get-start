package com.springcloudneflixeureka.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringCloudNetflixEurekaRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudNetflixEurekaRegistryApplication.class, args);
	}

}
