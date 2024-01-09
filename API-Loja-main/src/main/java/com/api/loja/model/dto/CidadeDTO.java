package com.api.loja.model.dto;

import java.io.Serializable;
import org.springframework.hateoas.RepresentationModel;
import com.github.dozermapper.core.Mapping;
import com.api.loja.model.Cidade;

public class CidadeDTO extends RepresentationModel<CidadeDTO> implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Mapping("id")
	private String key; 
	private String nome;
	
	public CidadeDTO() {
	}
	
	public CidadeDTO(String nome) {
		super();
		this.nome = nome;
	}


	public CidadeDTO(Cidade obj) {
		//this.key = obj.getId();
		this.nome = obj.getNome();
	}

	public String getId() {
		return key;
	}

	public void setId(String id) {
		this.key = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

	public Cidade build() {
		Cidade cidade = new Cidade();
		cidade.setNome(this.nome);
		return cidade;
	}

}
