package com.pablovvoliveira.vendasapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnimalConfiguration {
	
	@Bean(name = "cachorro")
	Animal cachorro() {
		return new Animal() {
			@Override
			public void fazerBarulho() {
				System.out.println("Au au");
			}
		};
		
	}
	
	@Bean(name = "gato")
	Animal gato() {
		return new Animal() {
			@Override
			public void fazerBarulho() {
				System.out.println("Miau");
			}
		};
	}
}
