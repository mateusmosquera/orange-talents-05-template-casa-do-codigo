package br.com.zupacademy.mateus.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.mateus.casadocodigo.controller.dto.PaisDTO;
import br.com.zupacademy.mateus.casadocodigo.model.Pais;
import br.com.zupacademy.mateus.casadocodigo.repository.PaisRepository;

@RestController
@RequestMapping(value = "/pais")
public class PaisController {
	
	@Autowired
	private PaisRepository paisRepository;
	
	@PostMapping
	public ResponseEntity<Object> cadastrar(@RequestBody @Valid PaisDTO paisDto){
		
		Pais newPais = paisDto.toModel();
		
		paisRepository.save(newPais);
		
		return ResponseEntity.ok().build();
	}
	
}
