package com.api.loja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.loja.model.Estado;
import com.api.loja.repository.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository estadoRepository;

	public List<Estado> listar() {
		return estadoRepository.findAll();
	}
	
	public Estado salvar(Estado estado) {
		Estado estadoAtual =  estadoRepository.save(estado);
		return estadoAtual;
	}
	
	public Estado buscar(Long id) {
		Estado estadoAtual = estadoRepository.findById(id).get();
		return estadoAtual;
	}
	
	public void excluir(Long id) {
		estadoRepository.deleteById(id);
	}
}
