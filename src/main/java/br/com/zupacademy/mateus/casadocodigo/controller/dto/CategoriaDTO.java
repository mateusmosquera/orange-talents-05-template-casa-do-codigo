package br.com.zupacademy.mateus.casadocodigo.controller.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.zupacademy.mateus.casadocodigo.model.Categoria;

public class CategoriaDTO {
	
	@NotBlank
	private String nome;
	
	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public CategoriaDTO(@NotBlank String nome) {
		this.nome = nome;
	}

	public Categoria toModel() {
		return new Categoria(this.nome);
	}
	
	public String getNome() {
		return nome;
	}
	
}