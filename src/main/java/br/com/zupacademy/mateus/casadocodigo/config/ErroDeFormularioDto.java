package br.com.zupacademy.mateus.casadocodigo.config;

public class ErroDeFormularioDto {
	
	private String campo;
	private String mensagem;
	
	public ErroDeFormularioDto(String campo, String mensagem) {
		this.campo = campo;
		this.mensagem = mensagem;
	}

	public String getCampo() {
		return campo;
	}

	public String getMensagem() {
		return mensagem;
	}
	
}
