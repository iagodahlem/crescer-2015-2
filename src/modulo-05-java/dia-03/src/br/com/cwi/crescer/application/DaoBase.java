package br.com.cwi.crescer.application;

import br.com.cwi.crescer.dao.ClienteDao;
import br.com.cwi.crescer.dao.IDaoBase;
import br.com.cwi.crescer.dao.PedidoDao;

public class DaoBase implements IDaoBase {

	@Override
	public ClienteDao CriarClienteDao() {
		return new ClienteDao();
	}

	@Override
	public PedidoDao CriarPedidoDao() {
		return new PedidoDao();
	}

}
