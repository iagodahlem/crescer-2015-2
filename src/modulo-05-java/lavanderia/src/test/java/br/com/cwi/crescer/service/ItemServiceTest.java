package br.com.cwi.crescer.service;

import java.math.BigDecimal;

import br.com.cwi.crescer.domain.Item;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class ItemServiceTest {
	
	@InjectMocks
	private ItemService itemService;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetValorTotalItem() throws Exception {
		Item item = new Item();
		BigDecimal peso = new BigDecimal("12");
		BigDecimal valorUnitario = new BigDecimal("12");
		item.setPeso(peso);
		item.setValorUnitario(valorUnitario);
		
		BigDecimal valorEsperado = new BigDecimal("144");
		
		BigDecimal valorTotal = itemService.getValorTotalItem(item);
		
		Assert.assertEquals(valorEsperado, valorTotal);
	}

}
