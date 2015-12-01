package br.com.cwi.crescer.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.cwi.crescer.dao.ProdutoDAO;
import br.com.cwi.crescer.dto.ProdutoDTO;

public class ProdutoServiceTest {
	
	@InjectMocks
	private ProdutoService produtoService;
	
	@Mock
	private ProdutoDAO produtoDAO;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void produtoNaoÉUnico() throws Exception {
		
		ProdutoDTO produtoDTO = new ProdutoDTO();
		
		produtoDTO.setMaterialDescricao("Delicado");
		produtoDTO.setServicoDescricao("Lavar");
		
		Assert.assertTrue(produtoService.verificaProdutoUnico(produtoDTO));
	}

}
