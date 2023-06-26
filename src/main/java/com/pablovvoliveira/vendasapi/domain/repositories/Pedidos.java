package com.pablovvoliveira.vendasapi.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pablovvoliveira.vendasapi.domain.entity.Pedido;

public interface Pedidos extends JpaRepository<Pedido, Integer> {

}
