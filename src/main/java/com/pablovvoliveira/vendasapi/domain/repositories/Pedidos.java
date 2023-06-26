package com.pablovvoliveira.vendasapi.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pablovvoliveira.vendasapi.domain.entity.Cliente;
import com.pablovvoliveira.vendasapi.domain.entity.Pedido;

public interface Pedidos extends JpaRepository<Pedido, Integer> {

	List<Pedido> findByCliente(Cliente cliente);
}
