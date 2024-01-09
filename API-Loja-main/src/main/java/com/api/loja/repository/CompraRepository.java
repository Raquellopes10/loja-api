package com.api.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.loja.model.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long> {

}
