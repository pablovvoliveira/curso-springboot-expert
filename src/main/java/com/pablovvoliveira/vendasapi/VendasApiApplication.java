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
			System.out.println("Salvando clientes:");
			clientes.save(new Cliente("Pablo"));
			clientes.save(new Cliente("Tonho"));
			
			List<Cliente> todosClientes = clientes.findAll();
			todosClientes.forEach(System.out::println);
			
			System.out.println();
			System.out.println("Atualizando clientes...");
			todosClientes.forEach(c -> {
				c.setNome(c.getNome() + " atualizado");
				clientes.save(c);
			});
			
			System.out.println();
			System.out.println("Buscando clientes");
			clientes.findByNomeLike("Pablo").forEach(System.out::print);
			
			System.out.println();
			System.out.println();
			System.out.println("Deletando clientes");
			clientes.findAll().forEach(c -> {
				clientes.delete(c);
			});
			todosClientes = clientes.findAll();
			if(todosClientes.isEmpty()) {
				System.out.println("Nenhum cliente encontrado");
			}
			todosClientes.forEach(System.out::println); 
			
			
			
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(VendasApiApplication.class, args);
	}

}
