package com.api.loja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.loja.model.Produto;
import com.api.loja.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public List<Produto> listar() {
		return produtoRepository.findAll();
	}

	public Produto salvar(Produto papel) {
		Produto produtoAtual = produtoRepository.save(papel);
		return produtoAtual;
	}

	public Produto buscar(Long id) {
		Produto produtoAtual = produtoRepository.findById(id).get();
		return produtoAtual;
	}

	public void excluir(Long id) {
		produtoRepository.deleteById(id);
	}

}
