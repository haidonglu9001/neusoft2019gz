package com.neusoft.oa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.neusoft.oa.hr.mapper"})
public class NeusoftGzoa2019Application {

	public static void main(String[] args) {
		SpringApplication.run(NeusoftGzoa2019Application.class, args);
	}

}
