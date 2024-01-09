package com.api.loja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.loja.model.ProdutoImagem;
import com.api.loja.service.ProdutoImagemService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/produtoImagens")
public class ProdutoImagemControler {

	@Autowired
	private ProdutoImagemService produtoImagensService;

	@GetMapping
	public List<ProdutoImagem> buscarTodos() {
		return produtoImagensService.buscarTodos();
	}

	@GetMapping("/{id}")
	public List<ProdutoImagem> buscarPorProduto(@PathVariable("id") Long idProduto) {
		return produtoImagensService.buscarPorProduto(idProduto);
	}

	@PostMapping
	public ProdutoImagem inserir(@RequestParam("idProduto") Long idProduto, @RequestParam("file") MultipartFile file) {
		return produtoImagensService.inserir(idProduto, file);
	}

	@PutMapping
	public ProdutoImagem alterar(@RequestBody ProdutoImagem objeto) {
		return produtoImagensService.alterar(objeto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
		produtoImagensService.excluir(id);
		return ResponseEntity.ok().build();
	}

}
