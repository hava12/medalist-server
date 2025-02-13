package com.medalist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserAppApplication {

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(UserAppApplication.class);
		// Map<String, Object> defaultProps = new HashMap<>();
		// defaultProps.put("DOCKER_HOST", "unix://~/.rd/docker.sock");
		// app.setDefaultProperties(defaultProps);
		app.run(args);
	}

}
