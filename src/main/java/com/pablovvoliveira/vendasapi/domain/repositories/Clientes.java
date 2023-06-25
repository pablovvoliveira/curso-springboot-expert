package com.pablovvoliveira.vendasapi.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pablovvoliveira.vendasapi.domain.entity.Cliente;

public interface Clientes extends JpaRepository<Cliente, Integer>{

	List<Cliente> findByNomeLike(String nome);
	
}
