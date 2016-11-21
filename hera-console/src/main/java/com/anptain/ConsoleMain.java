package com.anptain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
public class ConsoleMain {
	public static void main(String[] args) {
		SpringApplication.run(ConsoleMain.class, args);
	}
}
