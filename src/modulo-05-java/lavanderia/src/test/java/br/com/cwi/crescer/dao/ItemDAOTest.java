package br.com.cwi.crescer.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.domain.Item;

public class ItemDAOTest extends AbstractInfrastructureTest {

	@Autowired
	private ItemDAO itemDAO;
	
	@Test
	public void testFindById() throws Exception {
		Item item = itemDAO.findById(1L);
		Assert.assertNotNull(item);
	}

}
