package com.api.loja.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.api.loja.model.Produto;
import com.api.loja.model.ProdutoImagem;
import com.api.loja.repository.ProdutoImagemRepository;
import com.api.loja.repository.ProdutoRepository;

@Service
public class ProdutoImagemService {

	@Autowired
	private ProdutoImagemRepository produtoImagensRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<ProdutoImagem> buscarTodos() {
		return produtoImagensRepository.findAll();
	}

	public List<ProdutoImagem> buscarPorProduto(Long idProduto) {
		List<ProdutoImagem> listaProdutoImagens = produtoImagensRepository.findByProdutoId(idProduto);

		for (ProdutoImagem produtoImagens : listaProdutoImagens) {
			try (InputStream in = new FileInputStream("c:/imagens/" + produtoImagens.getNome())) {
				produtoImagens.setArquivo(IOUtils.toByteArray(in));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return listaProdutoImagens;
	}

	public ProdutoImagem inserir(Long idProduto, MultipartFile file) {
		Produto produto = produtoRepository.findById(idProduto).get();
		ProdutoImagem objeto = new ProdutoImagem();

		try {
			if (!file.isEmpty()) {
				byte[] bytes = file.getBytes();
				String nomeImagem = String.valueOf(produto.getId()) + file.getOriginalFilename();
				Path caminho = Paths.get("c:/imagens/" + nomeImagem);
				Files.write(caminho, bytes);
				objeto.setNome(nomeImagem);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		objeto.setProduto(produto);
		objeto = produtoImagensRepository.saveAndFlush(objeto);
		return objeto;
	}

	public ProdutoImagem alterar(ProdutoImagem objeto) {
		return produtoImagensRepository.saveAndFlush(objeto);
	}

	public void excluir(Long id) {
		ProdutoImagem objeto = produtoImagensRepository.findById(id).get();
		produtoImagensRepository.delete(objeto);
	}

}
