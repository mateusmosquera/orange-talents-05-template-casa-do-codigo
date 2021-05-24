package br.com.zupacademy.mateus.casadocodigo.controller.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zupacademy.mateus.casadocodigo.controller.annotations.UniqueValue;
import br.com.zupacademy.mateus.casadocodigo.model.Autor;

public class AutorDTO {
	
	@NotBlank 
	private String nome;
	@Email @NotBlank @UniqueValue(domainClass = Autor.class, fieldName = "email", message = "Email já cadastrada")
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

	public String getEmail() {
		return email;
	}
	
}
