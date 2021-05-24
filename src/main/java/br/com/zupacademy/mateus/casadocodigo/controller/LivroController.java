package br.com.zupacademy.mateus.casadocodigo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.mateus.casadocodigo.controller.dto.LivroDTO;
import br.com.zupacademy.mateus.casadocodigo.controller.response.DetalheLivroResponse;
import br.com.zupacademy.mateus.casadocodigo.controller.response.ListarLivroResponse;
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
	
	@GetMapping(value="/listar")
	public List<ListarLivroResponse> listar(){
		
		List<Livro> livros = (List<Livro>) livroRepository.findAll();
		List<ListarLivroResponse> response = new ArrayList<>();
		for(Livro l : livros) {
			ListarLivroResponse newLivroResponse = l.ToModelListarLivroResponse();
			response.add(newLivroResponse);
		}
		return response;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalheLivroResponse> detalhar(@PathVariable Long id){
		Optional<Livro> livro = livroRepository.findById(id);
		
		if(livro.isPresent()) {
			return ResponseEntity.ok(new DetalheLivroResponse(livro.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
}
