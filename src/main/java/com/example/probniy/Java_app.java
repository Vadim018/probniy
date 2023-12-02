package com.example.probniy;

import com.example.probniy.entity.Role;
import com.example.probniy.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Java_app {

	public static void main(String[] args) {
		SpringApplication.run(Java_app.class, args);
	}

	@Bean
	CommandLineRunner run(RoleRepository roleRepository) {
		return args -> {
			if (roleRepository.findAll().isEmpty()) {
				roleRepository.save(new Role(1L, "ROLE_User"));
				roleRepository.save(new Role(2L, "ROLE_Admin"));
			}
		};
	}
}