package com.api.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.loja.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}
