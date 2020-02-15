package org.iker.kata.lonja.katalonja.core;

import static org.junit.Assert.assertEquals;

import org.iker.kata.lonja.katalonja.excepciones.ExceedMaxWeightException;
import org.junit.Test;

public class ComparadorDeMercadosTest {
private static final int PESO_MAXIMO = 200;

	@Test
	public void shouldBeLisboaBestBenefit() {
		int[] primeraCarga = new int[]{50, 100, 50};
		
		ComparadorDeMercados gen = new ComparadorDeMercados();
		String ciudad = "Lisboa";
		try {
			String c = gen.getMaximoBeneficio(primeraCarga, PESO_MAXIMO);
			System.out.println(c);
			assertEquals(gen.getMaximoBeneficio(primeraCarga, PESO_MAXIMO), ciudad);
		} catch (ExceedMaxWeightException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Test(expected = ExceedMaxWeightException.class)
	public void shouldReturnException() throws ExceedMaxWeightException{
		int[] primeraCarga = new int[]{51, 100, 50};
		
		ComparadorDeMercados gen = new ComparadorDeMercados();
		
		gen.getMaximoBeneficio(primeraCarga, PESO_MAXIMO);
		
	}
}
