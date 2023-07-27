package com.team4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.dto.entity")
@EnableJpaRepositories(basePackages = "com.model.persistence")
@SpringBootApplication(scanBasePackages = "com")
public class ProsperLendApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ProsperLendApplication.class, args);
	}
}
