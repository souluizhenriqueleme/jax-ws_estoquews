package br.com.lheme.estoque.modelo.usuario.exception;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class InfoFault {

	private String mensagem;
	private Date dataError;

	public InfoFault(String mensagem, Date dataErro) {
		this.mensagem = mensagem;
		this.dataError = dataErro;
	}
	
	public InfoFault() {
	}
}
