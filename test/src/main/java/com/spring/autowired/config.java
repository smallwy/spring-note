package com.spring.autowired;

import com.spring.autowired.service.FactoryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({"com.test.autowired"})
@EnableAspectJAutoProxy
public class config {

	@Bean
	public FactoryService factoryService(){
		return new FactoryService();
	}
}