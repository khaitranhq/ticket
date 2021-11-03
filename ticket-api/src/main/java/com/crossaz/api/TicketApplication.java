package com.crossaz.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.alibaba.dubbo.config.RegistryConfig;

@SpringBootApplication
public class TicketApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(TicketApplication.class, args);
		
		RegistryConfig registryConfig = context.getBean(RegistryConfig.class);
		System.out.println(registryConfig.getAddress());
	}

}
