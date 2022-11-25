package com.calculator.calculationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalculatorServiceApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(CalculatorServiceApplication.class, args);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
