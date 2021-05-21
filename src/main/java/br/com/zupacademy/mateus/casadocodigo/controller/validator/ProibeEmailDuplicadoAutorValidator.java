package br.com.zupacademy.mateus.casadocodigo.controller.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.mateus.casadocodigo.controller.dto.AutorDTO;
import br.com.zupacademy.mateus.casadocodigo.model.Autor;
import br.com.zupacademy.mateus.casadocodigo.repository.AutorRepository;

@Component
public class ProibeEmailDuplicadoAutorValidator implements Validator {
	
	@Autowired
	private AutorRepository autorRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		
		return AutorDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		AutorDTO dto = (AutorDTO) target;
		Optional<Autor> possivelAutor = autorRepository.findByEmail(dto.getEmail());
		
		if(possivelAutor.isPresent()) {
			errors.rejectValue("email",null,"Email já cadastrado:"+dto.getEmail());
		}
	}

}
