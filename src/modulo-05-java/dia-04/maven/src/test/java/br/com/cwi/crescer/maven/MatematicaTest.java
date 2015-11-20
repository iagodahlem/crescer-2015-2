package br.com.cwi.crescer.maven;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MatematicaTest {

	@Test
	public void somaCooreto() {
		int resultado = new Matematica().somar(4, 4);
		
		assertEquals(8, resultado);
	}
}
