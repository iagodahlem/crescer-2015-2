package br.com.cwi.crescer.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.AbstractInfrastructureTest;
import br.com.cwi.crescer.domain.Cidade;

public class CidadeDAOTest extends AbstractInfrastructureTest {

	@Autowired
	private CidadeDAO cidadeDAO;
	
	@Test
	public void testFindById() throws Exception {
		Cidade cidade = cidadeDAO.findById(1L);
		Assert.assertNotNull(cidade);
	}
	
	@Test
	public void deveListarTodasAsCidades() throws Exception {
		List<Cidade> cidades = cidadeDAO.listAll();
		Assert.assertNotNull(cidades);
	}

}
