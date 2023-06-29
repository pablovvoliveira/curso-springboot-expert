package com.pablovvoliveira.vendasapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pablovvoliveira.vendasapi.entity.Cliente;
import com.pablovvoliveira.vendasapi.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

	List<Pedido> findByCliente(Cliente cliente);
}
