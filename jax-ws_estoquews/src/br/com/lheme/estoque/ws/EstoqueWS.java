package br.com.lheme.estoque.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.lheme.estoque.modelo.item.Filtro;
import br.com.lheme.estoque.modelo.item.Filtros;
import br.com.lheme.estoque.modelo.item.Item;
import br.com.lheme.estoque.modelo.item.ItemDao;
import br.com.lheme.estoque.modelo.item.ListaItens;

@WebService
public class EstoqueWS {

	private ItemDao dao = new ItemDao();
	
	@WebMethod(operationName = "todosOsItens")
	@WebResult(name = "itens")
	public ListaItens getItens(Filtros filtros) {
		System.out.println("Chamando getItens()");
		List<Filtro> lista = filtros.getLista();
		List<Item> itensResultado = dao.todosItens(lista);
		return new ListaItens(itensResultado);
	}
}
