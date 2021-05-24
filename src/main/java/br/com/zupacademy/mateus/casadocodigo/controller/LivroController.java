package br.com.zupacademy.mateus.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.mateus.casadocodigo.controller.dto.LivroDTO;
import br.com.zupacademy.mateus.casadocodigo.model.Livro;
import br.com.zupacademy.mateus.casadocodigo.repository.LivroRepository;

@RestController
@RequestMapping(value="/livro")
public class LivroController {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private EntityManager manager;
	
	@PostMapping
	public ResponseEntity<Object> cadastrar(@RequestBody @Valid LivroDTO livroDto){
		Livro livro = livroDto.toModel(manager);
		
		livroRepository.save(livro);
		
		return ResponseEntity.ok().build();
	}
}
