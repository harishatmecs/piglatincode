package com.piglatin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class PiglatinApplication {

	public static void main(String[] args) {
		SpringApplication.run(PiglatinApplication.class, args);
	}

}
