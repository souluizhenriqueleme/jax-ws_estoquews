package br.com.lheme.estoque.ws;

import javax.xml.ws.Endpoint;

public class PublicaWebService {

	public static void main(String[] args) {
		EstoqueWS servico = new EstoqueWS();
		String url = "http://localhost:8080/estoquews";
		
		System.out.println("Servidor rodando " + url + "?wsdl");
		Endpoint.publish(url, servico);
	}
}
