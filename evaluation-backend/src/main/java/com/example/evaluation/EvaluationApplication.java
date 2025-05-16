package com.example.evaluation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@SpringBootApplication
@ComponentScan(basePackages = "com.example.evaluation")
public class EvaluationApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvaluationApplication.class, args);

		// Code de test de mot de passe ici
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "admin123";
		String hash = encoder.encode(rawPassword);
		System.out.println("Hash généré : " + hash);
	}
}
