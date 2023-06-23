package com.pablovvoliveira.vendasapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class VendasApiApplication {

	@Value("${application.name}")
	private String applicationName;
	
	@Cachorro
	private Animal animal;
	
	@Bean
	public CommandLineRunner executar() {
		return args -> {
			this.animal.fazerBarulho();
		};
	}
	
	@GetMapping("/hello")
	public String helloWorld() {
		return applicationName;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(VendasApiApplication.class, args);
	}

}
