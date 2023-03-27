package com.knimbus.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class KnimbusTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(KnimbusTestApplication.class, args);
	}
	
	@Bean
	public RestTemplate getRestTemplateInstance() {
		return new RestTemplate();
	}

}
