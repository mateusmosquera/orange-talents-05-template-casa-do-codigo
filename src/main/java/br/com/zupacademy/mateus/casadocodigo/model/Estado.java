package br.com.zupacademy.mateus.casadocodigo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Estado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	@NotNull
	@ManyToOne(fetch=FetchType.EAGER)
	private Pais pais;
	
	@Deprecated
	public Estado() {
		
	}
	
	public Estado(@NotBlank String nome, @NotNull Pais pais) {
		this.nome = nome;
		this.pais = pais;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Pais getPais() {
		return pais;
	}

	public boolean validaPais(Pais pais) {
		return this.pais.equals(pais);
	}
	
	
}
