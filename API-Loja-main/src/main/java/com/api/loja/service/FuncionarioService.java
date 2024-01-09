package com.api.loja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.loja.model.Funcionario;
import com.api.loja.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public List<Funcionario> listar() {
		return funcionarioRepository.findAll();
	}
	
	public Funcionario salvar(Funcionario funcionario) {
		Funcionario funcionarioAtual =  funcionarioRepository.save(funcionario);
		return funcionarioAtual;
	}
	
	public Funcionario buscar(Long id) {
		Funcionario funcionarioAtual = funcionarioRepository.findById(id).get();
		return funcionarioAtual;
	}
	
	public void excluir(Long id) {
		funcionarioRepository.deleteById(id);
	}

}
