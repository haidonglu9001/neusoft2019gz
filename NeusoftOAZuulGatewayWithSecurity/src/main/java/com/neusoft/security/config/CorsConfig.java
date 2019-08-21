package com.neusoft.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

//@Configuration
//@Order(-1)
public class CorsConfig extends WebMvcConfigurationSupport{

	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("*")
                .allowedOrigins("*")
                .allowedHeaders("*");
        super.addCorsMappings(registry);
        System.out.println("跨域访问配置。。。");
    }
	
	/*
	 * @Bean public CorsFilter corsFilter() { final UrlBasedCorsConfigurationSource
	 * source = new UrlBasedCorsConfigurationSource(); final CorsConfiguration
	 * config = new CorsConfiguration(); config.setAllowCredentials(false); //
	 * 允许cookies跨域 config.addAllowedOrigin("*");//
	 * #允许向该服务器提交请求的URI，*表示全部允许，在SpringMVC中，如果设成*，会自动转成当前请求头中的Origin
	 * config.addAllowedHeader("*");// #允许访问的头信息,*表示全部 config.setMaxAge(7200L);//
	 * 预检请求的缓存时间（秒），即在这个时间段里，对于相同的跨域请求不会再预检了 config.addAllowedMethod("*");//
	 * 允许提交请求的方法，*表示全部允许 source.registerCorsConfiguration("/**", config);
	 * System.out.println("跨域配置..."); return new CorsFilter(source); }
	 */
}
