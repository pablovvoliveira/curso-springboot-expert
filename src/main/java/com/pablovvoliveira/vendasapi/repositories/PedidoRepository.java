package com.pablovvoliveira.vendasapi.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pablovvoliveira.vendasapi.entity.Cliente;
import com.pablovvoliveira.vendasapi.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

	List<Pedido> findByCliente(Cliente cliente);
	
	@Query(" select p from Pedido p left join fetch p.itens where p.id = :id ") 
	Optional<Pedido> findByIdFetchItens(Integer id);
	
}
