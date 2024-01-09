package com.api.loja.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.loja.model.Compra;
import com.api.loja.model.ItensCompra;
import com.api.loja.repository.CompraRepository;
import com.api.loja.repository.ItensCompraRepository;

@Service
public class CompraService {

	@Autowired
	private CompraRepository compraRepository;

	@Autowired
	private ItensCompraRepository itensCompraRepository;

	public List<Compra> listar() {
		return compraRepository.findAll();
	}

	public Compra salvar(Compra compra) {
		return compraRepository.save(compra);
	}

	public Compra buscar(Long id) {
		return compraRepository.findById(id).orElse(null);
	}

	public void excluir(Long id) {
		Optional<ItensCompra> itensCompraList = itensCompraRepository.findById(id);

		if (!itensCompraList.isEmpty()) {
			throw new RuntimeException(
					"Não é possível excluir esta compra porque há itens de compra associados a ela.");
		}
		compraRepository.deleteById(id);
	}
}
