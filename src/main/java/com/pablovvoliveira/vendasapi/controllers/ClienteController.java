package com.pablovvoliveira.vendasapi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pablovvoliveira.vendasapi.domain.entity.Cliente;
import com.pablovvoliveira.vendasapi.domain.repositories.Clientes;

@Controller
@RequestMapping("/api/clientes")
public class ClienteController {
	
	@Autowired
	private Clientes clientes;
			
	@GetMapping(value = "/{id}")
	@ResponseBody
	public ResponseEntity<Cliente> getClienteById(@PathVariable Integer id) {
		Optional<Cliente> cliente = clientes.findById(id);
		if(cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
		Cliente clienteSalvo = clientes.save(cliente);
		return ResponseEntity.ok(clienteSalvo);
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseBody
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		Optional<Cliente> cliente = clientes.findById(id);
		if(cliente.isPresent()) {
			clientes.delete(cliente.get());
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody Cliente cliente) {
	    return clientes.findById(id)
	            .map(clienteExistente -> {
	                cliente.setId(clienteExistente.getId());
	                clientes.save(cliente);
	                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	            })
	            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@GetMapping
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> list = clientes.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/test")
	public ResponseEntity<List<Cliente>> find(Cliente filtro) {
		ExampleMatcher matcher = ExampleMatcher
				.matching()
				.withIgnoreCase()
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
		Example<Cliente> ex = Example.of(filtro, matcher);
		List<Cliente> lista = clientes.findAll(ex);
		return ResponseEntity.ok(lista);
		
	}
	
}
