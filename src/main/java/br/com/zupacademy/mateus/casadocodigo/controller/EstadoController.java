package br.com.zupacademy.mateus.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.mateus.casadocodigo.controller.dto.EstadoDTO;
import br.com.zupacademy.mateus.casadocodigo.model.Estado;
import br.com.zupacademy.mateus.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.mateus.casadocodigo.repository.PaisRepository;

@RestController
@RequestMapping(value = "/estado")
public class EstadoController {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private PaisRepository paisRepository;
	
	@PostMapping
	public ResponseEntity<Object> cadastrar(@RequestBody @Valid EstadoDTO estadoDto){
		
		Estado estado = estadoDto.toModel(paisRepository);
		
		estadoRepository.save(estado);
		
		return ResponseEntity.ok().build();
	}
}
