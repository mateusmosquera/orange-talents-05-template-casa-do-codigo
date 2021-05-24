package br.com.zupacademy.mateus.casadocodigo.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zupacademy.mateus.casadocodigo.controller.annotations.ExistsId;
import br.com.zupacademy.mateus.casadocodigo.controller.annotations.UniqueValue;
import br.com.zupacademy.mateus.casadocodigo.model.Autor;
import br.com.zupacademy.mateus.casadocodigo.model.Categoria;
import br.com.zupacademy.mateus.casadocodigo.model.Livro;

public class LivroDTO {

	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo", message = "Este titulo do livro já foi cadastrado")
	private String titulo;
	
	@NotBlank
	@Size(max = 500)
	private String resumo;
	@NotBlank
	private String sumario;
	
	@NotNull
	@Min(value = 20)
	private BigDecimal preco;
	
	@NotNull
	@Min(value=100)
	private int numeroDePag;
	
	@NotBlank
	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "isbn", message = "Este isbn já foi cadastrado")
	private String isbn;
	
	@Future
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataDaPublicacao;
	
	@NotNull
	@ExistsId(domainClass = Categoria.class, fieldName = "id", message = "Id da categoria não existe")
	private Long idCategoria;
	@NotNull
	@ExistsId(domainClass = Autor.class, fieldName = "id", message = "Id do Autor não existe")
	private Long idAutor;

	
	public LivroDTO(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario,
			@NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) int numeroDePag, @NotBlank @NotBlank String isbn, 
			@NotNull Long idCategoria, @NotNull Long idAutor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroDePag = numeroDePag;
		this.isbn = isbn;
		this.idCategoria = idCategoria;
		this.idAutor = idAutor;
	}
		
	public Long getIdCategoria() {
		return idCategoria;
	}

	public Long getIdAutor() {
		return idAutor;
	}

	public void setDataDaPublicacao(LocalDate dataDaPublicacao) {
		this.dataDaPublicacao = dataDaPublicacao;
	}

	public Livro toModel(EntityManager manager) {
		@NotNull Autor autor = manager.find(Autor.class, idAutor);
		@NotNull Categoria categoria = manager.find(Categoria.class, idCategoria);
		
		Assert.state(Objects.nonNull(autor),"Você esta querendo cadastrar um livro para um autor que nao existe no banco "+idAutor);
		Assert.state(Objects.nonNull(categoria),"Você esta querendo cadastrar um livro para uma categoria que nao existe no banco "+idCategoria);
		
		return new Livro(titulo, resumo, sumario, preco, numeroDePag, isbn,
				dataDaPublicacao, categoria, autor);
	}
	
}
