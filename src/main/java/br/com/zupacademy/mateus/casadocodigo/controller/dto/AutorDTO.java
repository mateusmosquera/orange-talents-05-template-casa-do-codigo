package br.com.zupacademy.mateus.casadocodigo.controller.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zupacademy.mateus.casadocodigo.model.Autor;

public class AutorDTO {
	
	@NotBlank 
	private String nome;
	@Email @NotBlank
	private String email;
	@NotBlank @Size(max=400)
	private String descricao;
	
	public AutorDTO(@NotBlank String nome,
			@Email @NotBlank String email,
			@NotBlank @Size(max=400) String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Autor toModel() {
		
		return new Autor(this.nome,this.email,this.descricao);
	}
	
}