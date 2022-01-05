package com.crossaz.booker;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.yaml.snakeyaml.emitter.ScalarAnalysis;

import com.crossaz.booker.config.DubboConfig;

@SpringBootApplication
@EnableConfigurationProperties(DubboConfig.class)
public class TicketBookerApplication {
    static Scanner sc = new Scanner(System.in);
    
	public static void main(String[] args) {
		SpringApplication.run(TicketBookerApplication.class, args);
		
		try {
			while(true) {
				String str = sc.nextLine();
				if (str.contains("quit"))
					return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
