package com.api.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.loja.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
