package br.com.lheme.estoque.main;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import br.com.lheme.estoque.modelo.item.Item;

public class TesteItemParaXml {

	public static void main(String[] args) throws JAXBException {
		Item item = new Item.Builder().comCodigo("MEA").comNome("MEAN").comQuantidade(4).comTipo("Livro").build();
		
		JAXBContext context = JAXBContext.newInstance(Item.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.marshal(item, System.out);
	}
}


//GERANDO O WSDL pelo CONSOLE: wsgen -cp bin br.com.lheme.estoque.ws.EstoqueWS -wsdl -inlineSchemas