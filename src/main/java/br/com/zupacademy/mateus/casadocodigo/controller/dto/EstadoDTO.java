package br.com.zupacademy.mateus.casadocodigo.controller.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.mateus.casadocodigo.controller.annotations.ExistsId;
import br.com.zupacademy.mateus.casadocodigo.controller.annotations.UniqueValue;
import br.com.zupacademy.mateus.casadocodigo.model.Estado;
import br.com.zupacademy.mateus.casadocodigo.model.Pais;
import br.com.zupacademy.mateus.casadocodigo.repository.PaisRepository;

public class EstadoDTO {
	
	@NotBlank
	@UniqueValue(domainClass = Estado.class,fieldName = "nome", message = "Estado já cadsatrado")
	private String nome;
	
	@NotNull
	@ExistsId(domainClass = Pais.class, fieldName = "id", message = "Id do País não existe")
	private Long paisid;

	public EstadoDTO(@NotBlank String nome, @NotNull Long paisId) {
		this.nome = nome;
		this.paisid = paisId;
	}

	public Estado toModel(PaisRepository paisRepository) {
		Pais pais = paisRepository.findById(this.paisid).get();
		return new Estado(nome, pais);
	}

}
