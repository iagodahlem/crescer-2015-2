package br.com.cwi.crescer.service;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.cwi.crescer.dao.ClienteDAO;
import br.com.cwi.crescer.dao.PedidoDAO;
import br.com.cwi.crescer.domain.Pedido;

public class PedidoServiceTest {

	@InjectMocks
	private PedidoService pedidoService;
	
	@Mock
	private PedidoDAO pedidoDAO;
	
	@Mock
	private ClienteDAO clienteDAO;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testCalcularDataEntrega() throws Exception {
		Pedido pedido = pedidoDAO.findById(1L);
		pedidoService.calcularDataEntrega(pedido);
	}

	@Test
	public void testCalculaValorFinalPedido() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testSomarPesoTotalDosItens() throws Exception {
		Mockito.when(pedidoDAO.findById(1L)).thenCallRealMethod();
		
		Pedido pedido = pedidoDAO.findById(1L);
		
		BigDecimal pesoTotal = pedidoService.somarPesoTotalDosItens(pedido);
		BigDecimal pesoEsperado = new BigDecimal("1");
		
		Assert.assertEquals(pesoEsperado, pesoTotal);
	}

	@Test
	public void testObterValorDesconto() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

}
