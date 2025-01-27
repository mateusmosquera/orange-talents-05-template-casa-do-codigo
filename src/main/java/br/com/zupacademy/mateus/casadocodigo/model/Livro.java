package br.com.zupacademy.mateus.casadocodigo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zupacademy.mateus.casadocodigo.controller.response.ListarLivroResponse;


@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
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
	private String isbn;
	
	@Future
	@NotNull
	private LocalDate dataDaPublicacao;

	@ManyToOne
	@NotNull
	@Valid
	private Categoria categoria;
	
	@ManyToOne
	@NotNull
	@Valid
	private Autor autor;
	
	@Deprecated
	public Livro() {
		
	}

	public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
			@NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) int numeroDePag, @NotBlank String isbn,
			@NotNull @Future LocalDate dataDaPublicacao, @NotNull @Valid Categoria categoria, @NotNull @Valid Autor autor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroDePag = numeroDePag;
		this.isbn = isbn;
		this.dataDaPublicacao = dataDaPublicacao;
		this.categoria = categoria;
		this.autor = autor;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public Autor getAutor() {
		return autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public int getNumeroDePag() {
		return numeroDePag;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataDaPublicacao() {
		return dataDaPublicacao;
	}


	public ListarLivroResponse ToModelListarLivroResponse() {

		return new ListarLivroResponse(this.id,this.titulo);
	}

}
