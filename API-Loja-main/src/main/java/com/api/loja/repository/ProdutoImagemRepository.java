package com.api.loja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.loja.model.ProdutoImagem;

public interface ProdutoImagemRepository extends JpaRepository<ProdutoImagem, Long> {
	 public List<ProdutoImagem> findByProdutoId(Long id);
}
