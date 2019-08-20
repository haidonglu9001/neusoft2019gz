package com.neusoft.ribbon.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;

@Configuration
public class AppConfig {
	
	//启用Ribbon：@LoadBalanced
	@Bean
	@LoadBalanced 
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	//配置Ribbon负载均衡算法，默认是轮询算法(Round)
	//推荐使用BestAvailableRule
	@Bean
	public IRule getRule() {
		return new BestAvailableRule();
	}
	
	

	@Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
	

}
