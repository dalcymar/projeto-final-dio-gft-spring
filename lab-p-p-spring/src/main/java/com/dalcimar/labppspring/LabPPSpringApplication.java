package com.dalcimar.labppspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Projeto Spring Boot gerado via Spring Initializr.
 * Os seguintes módulos foram selecionados:
 * - Spring Data JPA
 * - Spring Web
 * - H2 Database
 * OpenFeign
 * 
 * @author Dalcimar
 */

@EnableFeignClients
@SpringBootApplication
public class LabPPSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabPPSpringApplication.class, args);
	}

}
