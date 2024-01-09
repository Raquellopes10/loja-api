package com.api.loja.controller;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
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

import com.api.loja.model.Cidade;
import com.api.loja.model.dto.CidadeDTO;
import com.api.loja.model.mapper.DozerMapper;
import com.api.loja.service.CidadeService;

@RestController
@RequestMapping("/cidades")
public class CidadeControler {
	
	@Autowired
	private CidadeService cidadeService;
	
	@GetMapping
	public List<CidadeDTO> listar(){
		var cidade = cidadeService.listar();
		var CidadeDTO = DozerMapper.parseListObjects(cidade, CidadeDTO.class);
		return CidadeDTO;
	}
	
	@PostMapping
	public CidadeDTO adicionar(@RequestBody Cidade cidade) {
		Cidade cidadeAtual = cidadeService.salvar(cidade);
		CidadeDTO cidadeDTO = new CidadeDTO(cidadeAtual);
		return cidadeDTO;
	}
	
	@GetMapping("/{id}")
	public CidadeDTO buscar(@PathVariable("id") Long id) throws Exception {
		Cidade cidade = cidadeService.buscar(id);
		
		CidadeDTO vo = DozerMapper.parseObject(cidade, CidadeDTO.class);
		vo.add(linkTo(methodOn(CidadeControler.class).buscar(id)).withSelfRel());
		
		return vo;
	}


	@PutMapping("/{id}")
	public CidadeDTO atualizar(@PathVariable("id") Long id, 
							@RequestBody Cidade cidade) {
		try {
			Cidade cidadeAtual = cidadeService.buscar(id);
			
			BeanUtils.copyProperties(cidade, cidadeAtual, "id");
			
			Cidade cidadeAtualizada =  cidadeService.salvar(cidadeAtual);
			var vo = DozerMapper.parseObject(cidadeAtualizada, CidadeDTO.class);
			
			return vo;
			
		} catch (Exception e) {
			return null;
		}
	}
	
	@DeleteMapping("/{id}")
	public void apagar(@PathVariable("id") Long id) {
		cidadeService.excluir(id);
	}
}
