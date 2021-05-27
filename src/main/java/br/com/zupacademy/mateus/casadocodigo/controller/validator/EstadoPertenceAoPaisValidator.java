package br.com.zupacademy.mateus.casadocodigo.controller.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.mateus.casadocodigo.controller.dto.ClienteDTO;
import br.com.zupacademy.mateus.casadocodigo.model.Estado;
import br.com.zupacademy.mateus.casadocodigo.model.Pais;
import br.com.zupacademy.mateus.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.mateus.casadocodigo.repository.PaisRepository;

@Component
public class EstadoPertenceAoPaisValidator implements Validator{
	
	@Autowired
	EstadoRepository estadoRepository;
	@Autowired
	PaisRepository paisRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		
		return ClienteDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		ClienteDTO newCliente = (ClienteDTO) target;
		
		Pais pais = paisRepository.findById(newCliente.getPaisId()).get();
		Long estadoId = newCliente.getEstadoId();
		if(estadoId==null) {
			Optional<Estado> paisTemEstado = estadoRepository.findByPaisId(estadoId);
			if(paisTemEstado.isPresent()) {
				errors.reject("Este país tem estados cadsatrados, um estado precisa ser selecionado");
			}
			return;
		}
		
		Optional<Estado> estado = estadoRepository.findById(estadoId);
		if(estado.isEmpty()) {
			errors.reject("Não existe este estado cadastrado");
			return;
		}
		if(!estado.get().validaPais(pais)){
			errors.reject("Este estado não pertence a esse País");
			return;
		}
	}
}	
