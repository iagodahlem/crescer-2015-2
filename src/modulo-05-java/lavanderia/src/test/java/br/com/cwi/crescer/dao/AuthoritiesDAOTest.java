package br.com.cwi.crescer.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.AbstractInfrastructureTest;
import br.com.cwi.crescer.domain.Authorities;

public class AuthoritiesDAOTest extends AbstractInfrastructureTest {

	@Autowired
	private AuthoritiesDAO authsDAO;
	
	@Test
	public void deveListarTodasAsCidades() throws Exception {
		List<Authorities> auths = authsDAO.listAll();
		Assert.assertNotNull(auths);
	}
	
}
