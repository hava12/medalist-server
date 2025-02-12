package com.medalist.containers;

import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public class MySqlTestContainerConfig {

	@Container
	private static final MySQLContainer<?> mysqlContainer = new MySQLContainer<>("mysql:8.0.28")
		.withDatabaseName("medalist")
		.withUsername("root")
		.withPassword("root");

	static {
		mysqlContainer.start();
	}

	@Bean
	@Primary
	public DataSource dataSource() {
		return DataSourceBuilder.create()
			.url(mysqlContainer.getJdbcUrl())
			.username(mysqlContainer.getUsername())
			.password(mysqlContainer.getPassword())
			.driverClassName(mysqlContainer.getDriverClassName())
			.build();
	}

}
