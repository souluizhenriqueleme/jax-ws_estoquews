package br.com.lheme.estoque.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.lheme.estoque.modelo.item.Filtro;
import br.com.lheme.estoque.modelo.item.Filtros;
import br.com.lheme.estoque.modelo.item.Item;
import br.com.lheme.estoque.modelo.item.ItemDao;
import br.com.lheme.estoque.modelo.item.ItemValidador;
import br.com.lheme.estoque.modelo.item.ListaItens;
import br.com.lheme.estoque.modelo.usuario.AutorizacaoException;
import br.com.lheme.estoque.modelo.usuario.TokenDao;
import br.com.lheme.estoque.modelo.usuario.TokenUsuario;

@WebService
public class EstoqueWS {

	private ItemDao dao = new ItemDao();
	
	@WebMethod(operationName = "todosOsItens")
	@WebResult(name = "itens")
	public ListaItens getItens(@WebParam(name = "filtros") Filtros filtros) {
		System.out.println("Chamando getItens()");
		
		List<Filtro> lista = filtros.getLista();
		List<Item> itensResultado = dao.todosItens(lista);
		
		return new ListaItens(itensResultado);
	}
	
	@WebMethod(operationName = "cadastrarItem")
	@WebResult(name = "item")
	public Item cadastrarItem(@WebParam(name="tokenUsuario", header = true) TokenUsuario token,
			@WebParam(name="item")Item item) throws AutorizacaoException {
		
		System.out.println("cadastrando item " + item + ", Token: " + token);
		
		boolean valido = new TokenDao().ehValido(token);
		
		if(!valido) {
			throw new AutorizacaoException("Autorizacao falhou");
		}
		
		new ItemValidador(item).validate();
		
		this.dao.cadastrar(item);
		return item;
	}
}
