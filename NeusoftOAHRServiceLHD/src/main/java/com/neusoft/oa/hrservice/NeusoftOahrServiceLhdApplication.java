package com.neusoft.oa.hrservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NeusoftOahrServiceLhdApplication {

	public static void main(String[] args) {
		SpringApplication.run(NeusoftOahrServiceLhdApplication.class, args);
	}

}
