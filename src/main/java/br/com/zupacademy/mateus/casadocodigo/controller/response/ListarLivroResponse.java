package br.com.zupacademy.mateus.casadocodigo.controller.response;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ListarLivroResponse {
	
	@NotNull
	private Long id;
	@NotBlank
	private String titulo;
	
	public ListarLivroResponse(@NotNull Long id, @NotBlank String titulo) {
		this.id = id;
		this.titulo = titulo;
	}
	
	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}
	
}
