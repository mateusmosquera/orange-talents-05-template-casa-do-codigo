package br.com.zupacademy.mateus.casadocodigo.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.mateus.casadocodigo.controller.dto.AutorDTO;
import br.com.zupacademy.mateus.casadocodigo.controller.validator.ProibeEmailDuplicadoAutorValidator;
import br.com.zupacademy.mateus.casadocodigo.model.Autor;
import br.com.zupacademy.mateus.casadocodigo.repository.AutorRepository;

@RestController
@RequestMapping(value = "/autor")
public class AutorController {
	
	@Autowired
	private AutorRepository autorRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<Object> cadastrar(@RequestBody @Valid AutorDTO autorDTO){
		
		Autor autor = autorDTO.toModel();
		autorRepository.save(autor);
		
		return ResponseEntity.ok().build();
	}
}
