package com.neusoft.busmis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication

@PropertySource(value="classpath:jdbc.properties")
@PropertySource(value="classpath:my.properties")
public class SpringbootmvcwebmybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootmvcwebmybatisApplication.class, args);
	}

}
