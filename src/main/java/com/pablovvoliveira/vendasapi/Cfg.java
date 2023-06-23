package com.pablovvoliveira.vendasapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;



@Development
public class Cfg {

	@Bean
	CommandLineRunner exe() {
		return args -> {
			System.out.println("Rodando a configuração de desenvolvimento");
		};
	}
	
}
