package com.api.loja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.loja.model.Compra;
import com.api.loja.model.ItensCompra;
import com.api.loja.model.Produto;
import com.api.loja.repository.CompraRepository;
import com.api.loja.repository.ItensCompraRepository;
import com.api.loja.repository.ProdutoRepository;

@Service
public class ItensCompraService {
	
	@Autowired
	private ItensCompraRepository itensCompraRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CompraRepository compraRepository;
	
	public List<ItensCompra> listar() {
		return itensCompraRepository.findAll();
	}
	
	public ItensCompra salvar(ItensCompra itensCompra) {
		
		Compra compra = compraRepository.findById(itensCompra.getCompra().getId()).orElse(null);
		
		Produto produto = produtoRepository.findById(itensCompra.getProduto().getId()).orElse(null);
		
		itensCompra.setCompra(compra);
		itensCompra.setProduto(produto);
		
		ItensCompra itensCompraAtual =  itensCompraRepository.save(itensCompra);
		return itensCompraAtual;
	}
	
	public ItensCompra buscar(Long id) {
		ItensCompra itensCompraAtual = itensCompraRepository.findById(id).get();
		return itensCompraAtual;
	}
	
	public void excluir(Long id) {
		itensCompraRepository.deleteById(id);
	}
	
}
