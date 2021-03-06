package br.com.cwi.crescer.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.AbstractInfrastructureTest;
import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Cliente.SituacaoCliente;

public class ClienteDAOTest extends AbstractInfrastructureTest {

	@Autowired
	private ClienteDAO clienteDAO;
	
	@Test
	public void testFindById() throws Exception {
		Cliente cliente = clienteDAO.findById(1L);
		Assert.assertNotNull(cliente);
	}
	
	@Test
	public void deveListarTodosOsClientes() throws Exception {
		List<Cliente> clientes = clienteDAO.listAll();
		Assert.assertNotNull(clientes);
	}
	
	@Test
	public void deveBuscarClientesPorNome() throws Exception {
		List<Cliente> clientes = clienteDAO.listByNome("teste");
		Assert.assertNotNull(clientes);
	}
	
	@Test
    public void deveBuscarClientesAtivos() throws Exception {
        List<Cliente> clientes = clienteDAO.findBySituacao(SituacaoCliente.ATIVO);
        Assert.assertNotNull(clientes);
        Assert.assertFalse(clientes.isEmpty());

        for (Cliente cliente : clientes) {
            Assert.assertEquals(SituacaoCliente.ATIVO, cliente.getSituacao());
        }
    }
	
	@Test
	public void deveBuscarClienteComPedidos() throws Exception {
		Cliente cliente = clienteDAO.findById(1L);
		Assert.assertNotNull(cliente);
		Assert.assertNotNull(cliente.getPedidos());
	}
	
	@Test
	public void clienteTemCidade() throws Exception {
		Cliente cliente = clienteDAO.findById(1L);
		Assert.assertNotNull(cliente);
		Assert.assertNotNull(cliente.getCidade());
	}

}
