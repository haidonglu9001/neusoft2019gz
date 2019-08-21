package com.neusoft.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableZuulProxy
public class NeusoftMicroserviceGatewayWithZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(NeusoftMicroserviceGatewayWithZuulApplication.class, args);
	}

}
