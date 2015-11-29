package br.com.cwi.crescer.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.AbstractInfrastructureTest;
import br.com.cwi.crescer.domain.Material;

public class MaterialDAOTest extends AbstractInfrastructureTest {

	@Autowired
	private MaterialDAO materialDAO;
	
	@Test
	public void testFindById() throws Exception {
		Material material = materialDAO.findById(1L);
		Assert.assertNotNull(material);
	}
	
	@Test
	public void deveBuscarMateriais() throws Exception {
		List<Material> materiais = materialDAO.listAll();
		Assert.assertNotNull(materiais);
	}

}
