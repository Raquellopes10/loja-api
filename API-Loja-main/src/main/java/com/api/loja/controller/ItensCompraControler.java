package com.api.loja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.loja.model.ItensCompra;
import com.api.loja.service.ItensCompraService;

@RestController
@RequestMapping("/itensCompra")
public class ItensCompraControler {

	@Autowired
	private ItensCompraService itensCompraService;

	@GetMapping
	public List<ItensCompra> listarItensCompra() {
		List<ItensCompra> itensCompraList = itensCompraService.listar();
		return itensCompraList;
	}

	@PostMapping
	public ItensCompra salvarItensCompra(@RequestBody ItensCompra itensCompra) {
		ItensCompra itensCompraSalvo = itensCompraService.salvar(itensCompra);
		System.out.println(itensCompra.toString());
		return itensCompraSalvo;
	}

	@GetMapping("/{id}")
	public ItensCompra buscarItensCompra(@PathVariable Long id) {
		ItensCompra itensCompra = itensCompraService.buscar(id);
		return itensCompra;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirItensCompra(@PathVariable Long id) {
		itensCompraService.excluir(id);
		return ResponseEntity.noContent().build();
	}
}
