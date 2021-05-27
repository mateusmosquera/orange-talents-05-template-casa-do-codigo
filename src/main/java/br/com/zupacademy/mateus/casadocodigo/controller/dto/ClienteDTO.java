package br.com.zupacademy.mateus.casadocodigo.controller.dto;

import java.util.Optional;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import br.com.zupacademy.mateus.casadocodigo.controller.annotations.ExistsId;
import br.com.zupacademy.mateus.casadocodigo.controller.annotations.UniqueValue;
import br.com.zupacademy.mateus.casadocodigo.model.Cliente;
import br.com.zupacademy.mateus.casadocodigo.model.Estado;
import br.com.zupacademy.mateus.casadocodigo.model.Pais;
import br.com.zupacademy.mateus.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.mateus.casadocodigo.repository.PaisRepository;

public class ClienteDTO {
	
	@Email
	@NotBlank
	@UniqueValue(domainClass = Cliente.class, fieldName = "email", message = "Email já cadastrado")
	private String email;
	
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@CPF
	@NotBlank
	@UniqueValue(domainClass = Cliente.class, fieldName = "documento", message = "Documento já cadastrado")
	private String documento;
	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	
	@ExistsId(domainClass = Pais.class, fieldName = "id", message = "Id do País não esta cadastrado")
	@NotNull
	private Long paisId;
	@NotNull
	private Long estadoId;
	@NotBlank
	private String telefone;
	@NotBlank
	private String cep;
	
	
	
	public ClienteDTO(@Email @NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome,
			@CPF @NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotNull Long paisId, Long estadoId, @NotBlank String telefone,
			@NotBlank String cep) {
		super();
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.paisId = paisId;
		this.estadoId = estadoId;
		this.telefone = telefone;
		this.cep = cep;
	}



	public Cliente toModel(PaisRepository paisRepository,EstadoRepository estadoRepository) {
		Pais pais = paisRepository.findById(paisId).get();
		Optional<Estado> optEstado = estadoRepository.findById(estadoId);
		Estado estado = null;
		if(optEstado.isPresent()) {
			estado = optEstado.get();
		}
		
		return new Cliente(this.email, this.nome, this.sobrenome, 
				this.documento, this.endereco, this.complemento, 
				this.cidade, pais, estado, this.telefone, this.cep);
	}

	public Long getPaisId() {
		return paisId;
	}

	public Long getEstadoId() {
		return estadoId;
	}
	
}
