package com.neusoft.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableDiscoveryClient  //启用注册客户端
//@EnableEurekaClient ////启用注册客户端
@EnableHystrix //启用保护
@EnableHystrixDashboard  //启用Hystrix仪表盘

public class NeusoftOaRibbonAndFeignProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(NeusoftOaRibbonAndFeignProjectApplication.class, args);
	}

}
