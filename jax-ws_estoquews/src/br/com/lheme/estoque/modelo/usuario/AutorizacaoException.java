package br.com.lheme.estoque.modelo.usuario;

import java.util.Date;

import javax.xml.ws.WebFault;

import br.com.lheme.estoque.modelo.usuario.exception.InfoFault;

@WebFault(name = "AutorizacaoFault")
public class AutorizacaoException extends Exception {

	private static final long serialVersionUID = 1L;

	public AutorizacaoException(String mensagem) {
		super(mensagem);
	}
	
	public InfoFault getFaultInfo( ) {
		return new InfoFault("Token Invalido", new Date());
	}

}
