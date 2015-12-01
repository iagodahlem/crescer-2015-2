package br.com.cwi.crescer.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.AbstractInfrastructureTest;
import br.com.cwi.crescer.domain.Item;
import br.com.cwi.crescer.domain.Item.SituacaoItem;

public class ItemDAOTest extends AbstractInfrastructureTest {

	@Autowired
	private ItemDAO itemDAO;
	
	@Test
	public void testFindById() throws Exception {
		Item item = itemDAO.findById(301L);
		Assert.assertNotNull(item);
	}
	
	@Test
    public void deveBuscarItensPendentes() throws Exception {
        List<Item> itens = itemDAO.findBySituacao(SituacaoItem.PENDENTE);
        Assert.assertNotNull(itens);
        Assert.assertFalse(itens.isEmpty());

        for (Item item : itens) {
            Assert.assertEquals(SituacaoItem.PENDENTE, item.getSituacao());
        }
    }
	
	@Test
	public void itemTemUmPedido() throws Exception {
		Item item = itemDAO.findById(301L);
		Assert.assertNotNull(item.getPedido());
	}

	@Test
	public void itemTemUmProduto() throws Exception {
		Item item = itemDAO.findById(301L);
		Assert.assertNotNull(item.getProduto());
	}
	
	@Test
	public void deveBuscarItensPorPedido() throws Exception {
		List<Item> itens = itemDAO.findByIdPedido(1L);
		Assert.assertNotNull(itens);
	}
	
}
