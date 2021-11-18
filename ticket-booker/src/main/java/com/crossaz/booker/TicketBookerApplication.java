package com.crossaz.booker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.crossaz.booker.config.DubboConfig;

@SpringBootApplication
@EnableConfigurationProperties(DubboConfig.class)
public class TicketBookerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketBookerApplication.class, args);
	}

}
