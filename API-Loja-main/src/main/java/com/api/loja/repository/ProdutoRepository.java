package com.api.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.loja.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
