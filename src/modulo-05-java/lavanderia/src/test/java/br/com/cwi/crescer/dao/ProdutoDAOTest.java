package br.com.cwi.crescer.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.AbstractInfrastructureTest;
import br.com.cwi.crescer.domain.Produto;

public class ProdutoDAOTest extends AbstractInfrastructureTest {

	@Autowired
	private ProdutoDAO produtoDAO;
	
	@Test
	public void testFindById() throws Exception {
		Produto produto = produtoDAO.findById(1L);
		Assert.assertNotNull(produto);
	}
	
	@Test
	public void deveRetornarProdutos() throws Exception {
		List<Produto> produtos = produtoDAO.listAll();
		Assert.assertNotNull(produtos);
	}

	@Test
	public void produtoTemServico() throws Exception {
		Produto produto = produtoDAO.findById(1L);
		Assert.assertNotNull(produto.getServico());
	}
	
	@Test
	public void produtoTemMaterial() throws Exception {
		Produto produto = produtoDAO.findById(1L);
		Assert.assertNotNull(produto.getMaterial());
	}
	
	@Test
	public void buscarProdutoPorMaterial() throws Exception {
		List<Produto> produtos = produtoDAO.listByMaterialEServico("Delicado", null);
		Assert.assertNotNull(produtos);
	}
	
	@Test
	public void buscarProdutoPorServico() throws Exception {
		List<Produto> produtos = produtoDAO.listByMaterialEServico(null, "Lavar");
		Assert.assertNotNull(produtos);
	}
	
	@Test
	public void buscarProdutoPorMaterialEServico() throws Exception {
		List<Produto> produtos = produtoDAO.listByMaterialEServico("Pesado", "Secar");
		Assert.assertNotNull(produtos);
	}
	
}
