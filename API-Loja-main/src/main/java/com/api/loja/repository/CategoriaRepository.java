package com.api.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.loja.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
