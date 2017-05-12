package com.anptain.hera;

import java.math.BigDecimal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsoleMain {
	public static void main(String[] args) {
		//SpringApplication.run(ConsoleMain.class, args);
		
		System.out.println(new BigDecimal("0.6").multiply(new BigDecimal("0.583333")));
	}
}
