package br.com.zupacademy.mateus.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.mateus.casadocodigo.controller.dto.ClienteDTO;
import br.com.zupacademy.mateus.casadocodigo.controller.validator.EstadoPertenceAoPaisValidator;
import br.com.zupacademy.mateus.casadocodigo.model.Cliente;
import br.com.zupacademy.mateus.casadocodigo.repository.ClienteRepository;
import br.com.zupacademy.mateus.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.mateus.casadocodigo.repository.PaisRepository;

@RestController
@RequestMapping(value="/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired 
	private PaisRepository paisRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private EstadoPertenceAoPaisValidator validator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(validator);
	}
	
	@PostMapping 
	public ResponseEntity<?> cadastrar(@RequestBody @Valid ClienteDTO clienteDto){
		
		Cliente newCliente = clienteDto.toModel(paisRepository,estadoRepository);
		
		clienteRepository.save(newCliente);
		
		return ResponseEntity.ok().build();
	}
}
