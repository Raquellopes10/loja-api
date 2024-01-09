package com.api.loja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.loja.model.Cidade;
import com.api.loja.repository.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;

	public List<Cidade> listar() {
		return cidadeRepository.findAll();
	}
	
	public Cidade salvar(Cidade cidade) {
		Cidade cidadeAtual =  cidadeRepository.save(cidade);
		return cidadeAtual;
	}
	
	public Cidade buscar(Long id) throws Exception {
		Cidade cidadeAtual = cidadeRepository.findById(id).orElseThrow(() ->
																new Exception("Nao encontrado"));
		return cidadeAtual;
	}
	
	public void excluir(Long id) {
		cidadeRepository.deleteById(id);
	}
}
