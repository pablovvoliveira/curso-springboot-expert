package com.pablovvoliveira.vendasapi.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pablovvoliveira.vendasapi.domain.entity.Cliente;

public interface Clientes extends JpaRepository<Cliente, Integer>{

	List<Cliente> findByNomeLike(String nome);
	
	@Query(" select c from Cliente c left join fetch c.pedidos p where c.id = :id ")
	Cliente findClienteFetchPedidos(@Param("id") Integer id);
	
}
