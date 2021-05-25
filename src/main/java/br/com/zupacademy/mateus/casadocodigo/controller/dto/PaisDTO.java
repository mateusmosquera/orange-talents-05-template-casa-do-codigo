package br.com.zupacademy.mateus.casadocodigo.controller.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.zupacademy.mateus.casadocodigo.controller.annotations.UniqueValue;
import br.com.zupacademy.mateus.casadocodigo.model.Pais;

public class PaisDTO {
	
	@NotBlank
	@UniqueValue(domainClass = Pais.class, fieldName = "nome",message="País já foi cadastrado")
	private String nome;

	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public PaisDTO(@NotBlank String nome) {
		this.nome = nome;
	}

	public Pais toModel() {
		return new Pais(this.nome);
	}
	
	
}
