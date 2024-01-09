package com.api.loja.controller;


	import java.io.Serializable;
	import java.util.ArrayList;
	import java.util.List;
	import com.api.loja.model.Categoria;
	import com.fasterxml.jackson.annotation.JsonIgnore;
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.JoinColumn;
	import jakarta.persistence.JoinTable;
	import jakarta.persistence.ManyToMany;
	import jakarta.persistence.Table;

	@Entity
	@Table(name = "produtos")
	public class ProdutoControler implements Serializable {

		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		private String descricao;
		private Double valorVenda;
		private String marca;
		private Double quantidadeEstoque = 0.;
		private String nomeImagem;

		@JsonIgnore
		@ManyToMany
		@JoinTable(name = "PRODUTO_CATEGORIA", joinColumns = @JoinColumn(name = "produto_id"), 
					inverseJoinColumns = @JoinColumn(name = "categoria_id"))
		private List<Categoria> categorias = new ArrayList<>();

		public ProdutoControler() {
			super();
		}

		public String getNomeImagem() {
			return nomeImagem;
		}

		public void setNomeImagem(String nomeImagem) {
			this.nomeImagem = nomeImagem;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public Double getValorVenda() {
			return valorVenda;
		}

		public void setValorVenda(Double valorVenda) {
			this.valorVenda = valorVenda;
		}

		public String getMarca() {
			return marca;
		}

		public void setMarca(String marca) {
			this.marca = marca;
		}

		public Double getQuantidadeEstoque() {
			return quantidadeEstoque;
		}
		
		public List<Categoria> getCategorias() {
			return categorias;
		}

		public void setCategorias(List<Categoria> categorias) {
			this.categorias = categorias;
		}	

		public void setQuantidadeEstoque(Double quantidadeEstoque) {
			this.quantidadeEstoque = quantidadeEstoque;
		}

	}


