package br.com.cwi.crescer.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.AbstractInfrastructureTest;
import br.com.cwi.crescer.domain.Authorities;
import br.com.cwi.crescer.domain.AuthoritiesID;
import br.com.cwi.crescer.domain.Users;
import br.com.cwi.crescer.domain.Users.Enabled;

public class AuthoritiesDAOTest extends AbstractInfrastructureTest {

	@Autowired
	private AuthoritiesDAO authsDAO;
	
	@Test
	public void deveRetornarAuthoritiePorId() throws Exception {
		Users username = new Users();
		username.setUsername("user");
		username.setEnabled(Enabled.ENABLED);
		
		AuthoritiesID authsID = new AuthoritiesID();
		authsID.setUsername(username);
		authsID.setAuthority("ROLE_USER");
		
		Authorities auths = authsDAO.findById(authsID);
		Assert.assertNotNull(auths);
	}
	
	@Test
	public void deveListarTodasAsCidades() throws Exception {
		List<Authorities> auths = authsDAO.listAll();
		Assert.assertNotNull(auths);
	}
	
}
