package com.pablovvoliveira.vendasapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pablovvoliveira.vendasapi.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
