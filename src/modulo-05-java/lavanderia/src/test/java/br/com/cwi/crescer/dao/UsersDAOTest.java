package br.com.cwi.crescer.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.AbstractInfrastructureTest;
import br.com.cwi.crescer.domain.Users;
import br.com.cwi.crescer.domain.Users.Enabled;

public class UsersDAOTest extends AbstractInfrastructureTest {

	@Autowired
	private UsersDAO usersDAO;
	
	@Test
	public void deveBuscarUserPorNome() throws Exception {
		Users user = usersDAO.findByUsername("user");
		Assert.assertNotNull(user);
	}
	
	@Test
    public void deveBuscarUsuarioEnabled() throws Exception {
		Users user = usersDAO.findByUsername("user");
        Assert.assertNotNull(user);

        Assert.assertEquals(Enabled.ENABLED, user.getEnabled());
    }
	
	@Test
    public void deveBuscarUsuariosEnabled() throws Exception {
        List<Users> users = usersDAO.findByEnabled(Enabled.ENABLED);
        Assert.assertNotNull(users);
        Assert.assertFalse(users.isEmpty());

        for (Users user : users) {
            Assert.assertEquals(Enabled.ENABLED, user.getEnabled());
        }
    }
	
}
