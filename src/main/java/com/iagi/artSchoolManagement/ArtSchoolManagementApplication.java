package com.iagi.artSchoolManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.iagi.artSchoolManagement.repositories")
public class ArtSchoolManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArtSchoolManagementApplication.class, args);
	}

}
