package com.pablovvoliveira.vendasapi.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pablovvoliveira.vendasapi.domain.entity.Produto;

public interface Produtos extends JpaRepository<Produto, Integer>{

}
