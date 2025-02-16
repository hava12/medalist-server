package com.medalist;

import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserAppApplication {

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(UserAppApplication.class);
		app.run(args);
	}

}
