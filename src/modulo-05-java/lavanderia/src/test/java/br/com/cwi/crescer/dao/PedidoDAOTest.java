package br.com.cwi.crescer.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.AbstractInfrastructureTest;
import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.domain.Pedido.SituacaoPedido;

public class PedidoDAOTest extends AbstractInfrastructureTest {
	
	@Autowired
	private PedidoDAO pedidoDAO;

	@Test
	public void testFindById() throws Exception {
		Pedido pedido = pedidoDAO.findById(1L);
		Assert.assertNotNull(pedido);
	}
	
	@Test
	public void deveBuscarTodosOsPedidos() throws Exception {
		List<Pedido> pedidos = pedidoDAO.listAll();
		Assert.assertNotNull(pedidos);
	}
	
	@Test
    public void deveBuscarPedidosPendentes() throws Exception {
        List<Pedido> pedidos = pedidoDAO.findBySituacao(SituacaoPedido.PENDENTE);
        Assert.assertNotNull(pedidos);
        Assert.assertFalse(pedidos.isEmpty());

        for (Pedido pedido : pedidos) {
            Assert.assertEquals(SituacaoPedido.PENDENTE, pedido.getSituacao());
        }
    }
	
	@Test
	public void deveBuscarPedidoComCliente() throws Exception {
		Pedido pedido = pedidoDAO.findById(1L);
		Assert.assertNotNull(pedido);
		Assert.assertNotNull(pedido.getCliente());
	}
	
	@Test
	public void pedidoTemItens() throws Exception {
		Pedido pedido = pedidoDAO.findById(1L);
		Assert.assertNotNull(pedido);
		Assert.assertNotNull(pedido.getItens());
	}
	
	@Test
	public void deveListarPedidosPorCPF() throws Exception {
		List<Pedido> pedidos = pedidoDAO.listByCPFESituacao("123", null);
		Assert.assertNotNull(pedidos);
	}
	
	@Test
	public void deveListarPedidosPorSituacao() throws Exception {
		List<Pedido> pedidos = pedidoDAO.listByCPFESituacao(null, SituacaoPedido.PENDENTE);
		Assert.assertNotNull(pedidos);
	}
	
	@Test
	public void deveListarPedidosPorCPFESituacao() throws Exception {
		List<Pedido> pedidos = pedidoDAO.listByCPFESituacao("52426419407", SituacaoPedido.PENDENTE);
		Assert.assertNotNull(pedidos);
	}
	
}
