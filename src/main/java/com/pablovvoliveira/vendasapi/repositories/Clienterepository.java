package com.pablovvoliveira.vendasapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pablovvoliveira.vendasapi.entity.Cliente;

public interface Clienterepository extends JpaRepository<Cliente, Integer>{

	List<Cliente> findByNomeLike(String nome);
	
	@Query(" select c from Cliente c left join fetch c.pedidos p where c.id = :id ")
	Cliente findClienteFetchPedidos(@Param("id") Integer id);
	
}
