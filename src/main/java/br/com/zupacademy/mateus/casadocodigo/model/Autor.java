package br.com.zupacademy.mateus.casadocodigo.model;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	@Email @NotBlank
	private String email;
	@NotBlank @Size(max=400)
	private String descricao;
	@NotNull
	private Date cadastroInstante = Date.valueOf(LocalDate.now());

	@Deprecated
	public Autor() {
		
	}
	
	public Autor(@NotBlank String nome, @Email @NotBlank String email, @NotBlank @Size(max=400) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

}
