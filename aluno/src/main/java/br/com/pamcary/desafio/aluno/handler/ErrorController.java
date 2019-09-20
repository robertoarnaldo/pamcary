package br.com.pamcary.desafio.aluno.handler;


public class ErrorController {
	
	private String campo;
	private String erro;
	
	public ErrorController(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}
	
	

}
