package br.com.zupacademy.mateus.casadocodigo.controller.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.mateus.casadocodigo.controller.dto.CategoriaDTO;
import br.com.zupacademy.mateus.casadocodigo.model.Categoria;
import br.com.zupacademy.mateus.casadocodigo.repository.CategoriaRepository;

@Component
public class ProibeNomeDuplicadoCategoriaValidator implements Validator {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		
		return CategoriaDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		CategoriaDTO dto = (CategoriaDTO) target;
		Optional<Categoria> possivelCategoria = categoriaRepository.findByNome(dto.getNome());
		
		if(possivelCategoria.isPresent()) {
			errors.rejectValue("nome",null,"Nome da categoria já cadastrado:"+dto.getNome());
		}
	}
}
