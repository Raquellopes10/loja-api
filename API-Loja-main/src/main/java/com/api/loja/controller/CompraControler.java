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

import com.api.loja.model.Compra;
import com.api.loja.service.CompraService;

@RestController
@RequestMapping("/compra")
public class CompraControler {
	
	@Autowired
    private CompraService compraService;

    @GetMapping
    public List<Compra> listarCompras() {
        List<Compra> compraList = compraService.listar();
        return compraList;
    }

    @PostMapping
    public Compra salvarCompra(@RequestBody Compra compra) {
        Compra compraSalva = compraService.salvar(compra);
        return compraSalva;
    }

    @GetMapping("/{id}")
    public Compra buscarCompra(@PathVariable Long id) {
        Compra compra = compraService.buscar(id);
        return compra;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCompra(@PathVariable Long id) {
        compraService.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
