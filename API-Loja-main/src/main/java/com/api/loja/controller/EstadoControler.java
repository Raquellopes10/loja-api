package com.api.loja.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.loja.model.Estado;
import com.api.loja.service.EstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoControler {
	
	@Autowired
	private EstadoService estadoService;
	
	@GetMapping
	public List<Estado> listar(){
		return estadoService.listar();
	}
	
	@PostMapping
	public Estado adicionar(@RequestBody Estado estado) {
		return estadoService.salvar(estado);
	}
	
	@GetMapping("/{id}")
	public Estado buscar(@PathVariable("id") Long id) {
		return estadoService.buscar(id);
	}
	
	@PutMapping("/{id}")
	public Estado atualizar(@PathVariable("id") Long id, 
							@RequestBody Estado estado) {
		try {
			Estado estadoAtual = estadoService.buscar(id);
			
			BeanUtils.copyProperties(estado, estadoAtual, "id");
			
			return estadoService.salvar(estadoAtual);
		} catch (Exception e) {
			return null;
		}
	}
	
	@DeleteMapping("/{id}")
	public void apagar(@PathVariable("id") Long id) {
		estadoService.excluir(id);
	}
}
