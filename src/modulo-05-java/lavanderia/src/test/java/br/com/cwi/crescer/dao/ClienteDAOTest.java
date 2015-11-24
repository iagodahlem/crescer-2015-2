package br.com.cwi.crescer.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.AbstractInfrastructureTest;
import br.com.cwi.crescer.domain.Cliente;

public class ClienteDAOTest extends AbstractInfrastructureTest {

	@Autowired
	private ClienteDAO clienteDAO;
	
	@Test
	public void testFindById() throws Exception {
		Cliente cliente = clienteDAO.findById(1L);
		Assert.assertNotNull(cliente);
	}
	
	@Test
	public void deveBuscarClienteComPedidos() throws Exception {
		Cliente cliente = clienteDAO.findById(1L);
		Assert.assertNotNull(cliente);
		Assert.assertNotNull(cliente.getPedidos());
	}
	
	@Test
	public void clienteTemEndereco() throws Exception {
		Cliente cliente = clienteDAO.findById(1L);
		Assert.assertNotNull(cliente);
		Assert.assertNotNull(cliente.getEndereco());
		Assert.assertNotNull(cliente.getEndereco().getEndereco());
		Assert.assertNotNull(cliente.getEndereco().getCep());
		Assert.assertNotNull(cliente.getEndereco().getBairro());
		Assert.assertNotNull(cliente.getEndereco().getCidade());
	}

}
