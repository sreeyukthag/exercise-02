package com.edstem.assessment_02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Assessment02Application {

	public static void main(String[] args) {
		SpringApplication.run(Assessment02Application.class, args);
	}
}
