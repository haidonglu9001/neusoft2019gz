package com.neusoft.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class NeusoftEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NeusoftEurekaServerApplication.class, args);
	}

}
