package com.pablovvoliveira.vendasapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import com.pablovvoliveira.vendasapi.domain.entity.Cliente;
import com.pablovvoliveira.vendasapi.domain.repositories.Clientes;

@SpringBootApplication
@RestController
public class VendasApiApplication {

	@Bean
	public CommandLineRunner init(@Autowired Clientes clientes) {
		return args -> {
			clientes.salvar(new Cliente("Pablo"));
			clientes.salvar(new Cliente("Tonho"));
			
			List<Cliente> todosClientes = clientes.obterTodos();
			todosClientes.forEach(System.out::println);
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(VendasApiApplication.class, args);
	}

}
