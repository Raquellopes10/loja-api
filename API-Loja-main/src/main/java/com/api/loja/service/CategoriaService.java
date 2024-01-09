package com.api.loja.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.loja.model.Categoria;
import com.api.loja.model.dto.CategoriaDTO;


@Service
public class CategoriaService {
	
	@Autowired
	private com.api.loja.repository.CategoriaRepository categoriaRepository;
	
	public Categoria find(Long id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		return categoria.orElseThrow(() -> new ObjectNotFoundException(
				"Categoria não encontrato! Id: " + id, categoria));
	}
	
	public Categoria insert(Categoria categoria) {
		categoria.setId(null);
		return categoriaRepository.save(categoria);
	}
	
	public Categoria update(Categoria obj) {
		Categoria newObj = find(obj.getId());
		updateData(newObj, obj);
		return categoriaRepository.save(newObj);
	}
	
	public void delete(Long id) throws Exception {
		this.find(id);
		try {
			categoriaRepository.deleteById(id);
			
		} catch (Exception e) {
			throw new Exception("Não é possivel excluir uma categoria que tenha produtos");
		}
	}
	
	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}
	
	public Categoria fromDTO(CategoriaDTO objDto) {
		return new Categoria(objDto.getId(), objDto.getNome());
	}
	
	private void updateData(Categoria newObj, Categoria obj) {
		newObj.setNome(obj.getNome());
	}
}
