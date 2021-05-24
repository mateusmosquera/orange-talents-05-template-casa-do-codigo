package br.com.zupacademy.mateus.casadocodigo.controller.response;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

import br.com.zupacademy.mateus.casadocodigo.model.Autor;
import br.com.zupacademy.mateus.casadocodigo.model.Livro;

public class DetalheLivroResponse {
	
	private DetalheSiteAutorResponse autor;
	
	private String titulo;
	
	private String resumo;
	
	private String sumario;

	private BigDecimal preco;

	private int numeroDePag;
	
	private String isbn;
	
	private String dataDaPublicacao;

	public DetalheLivroResponse(Livro livro) {
		this.autor = new DetalheSiteAutorResponse(livro.getAutor());
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.numeroDePag = livro.getNumeroDePag();
		this.isbn = livro.getIsbn();
		this.dataDaPublicacao = livro.getDataDaPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	public DetalheSiteAutorResponse getAutor() {
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

	public String getDataDaPublicacao() {
		return dataDaPublicacao;
	}
	
}
