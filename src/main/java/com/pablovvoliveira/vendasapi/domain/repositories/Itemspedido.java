package com.pablovvoliveira.vendasapi.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pablovvoliveira.vendasapi.domain.entity.ItemPedido;

public interface Itemspedido extends JpaRepository<ItemPedido, Integer>{

}
