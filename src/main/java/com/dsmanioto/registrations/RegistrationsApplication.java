package com.dsmanioto.registrations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class RegistrationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationsApplication.class, args);
	}

}
