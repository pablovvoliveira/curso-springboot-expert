package com.pablovvoliveira.vendasapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablovvoliveira.vendasapi.model.Cliente;
import com.pablovvoliveira.vendasapi.repository.ClientesRepository;

@Service
public class ClientesService {
	
	@Autowired
	private ClientesRepository repository;
		
	public void salvarCliente(Cliente cliente) {
		validarCliente(cliente);
		this.repository.persistir(cliente);
	}
	
	public void validarCliente(Cliente cliente) {
		// aplica validações
	}

}
