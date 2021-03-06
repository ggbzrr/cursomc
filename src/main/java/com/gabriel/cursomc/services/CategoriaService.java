package com.gabriel.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.cursomc.domain.Categoria;
import com.gabriel.cursomc.repositories.CategoriaRepository;
import com.gabriel.cursomc.services.exceptions.ObjectNotFoundExcepiton;

@Service
public class CategoriaService {
	//responsavel por fazer consult no repository
	
	
	//qndo declara uma dependencia dentro de uma classe	e coloca o autowired, 
	//essa dependencia sera instanciada automaticamente pelo spring	
	@Autowired
	private CategoriaRepository repo;

		public Categoria buscar(Integer id) {
			Optional<Categoria> obj = repo.findById(id);
			
			return obj.orElseThrow(() -> new ObjectNotFoundExcepiton(
			"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
		}
}
