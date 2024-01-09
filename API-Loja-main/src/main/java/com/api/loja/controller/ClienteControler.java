package com.api.loja.controller;

import java.util.List;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.loja.model.Cliente;
import com.api.loja.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteControler {
	
	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public List<Cliente> listar() {
		return clienteService.listar();
	}

	@PostMapping
	public Cliente adicionar(@RequestBody Cliente cliente) {
		return clienteService.salvar(cliente);
	}

	@GetMapping("/{id}")
	public Cliente buscar(@PathVariable("id") Long id) {
		return clienteService.buscar(id);
	}

	@PutMapping("/{id}")
	public Cliente atualizar(@PathVariable("id") Long id, @RequestBody Cliente compra) {
		try {
			Cliente clienteAtual = clienteService.buscar(id);
			BeanUtils.copyProperties(compra, clienteAtual, "id");

			return clienteService.salvar(clienteAtual);
		} catch (Exception e) {
			return null;
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> apagar(@PathVariable("id") Long id) throws Exception {
		clienteService.excluir(id);
		return ResponseEntity.ok().build();
	}

}
