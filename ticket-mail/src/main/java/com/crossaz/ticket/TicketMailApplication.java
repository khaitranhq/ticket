package com.crossaz.ticket;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
public class TicketMailApplication {
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        SpringApplication.run(TicketMailApplication.class, args);
        
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