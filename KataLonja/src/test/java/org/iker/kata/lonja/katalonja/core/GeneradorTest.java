package org.iker.kata.lonja.katalonja.core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.iker.kata.lonja.katalonja.core.Generador;
import org.iker.kata.lonja.katalonja.excepciones.ExceedMaxWeightException;

public class GeneradorTest {

	private static final int PESO_MAXIMO = 200;
	
	@Test
	public void shouldBeLisboaBestBenefit() {
		int[] primeraCarga = new int[]{50, 100, 50};
		
		Generador gen = new Generador();
		String ciudad = "Lisboa";
		try {
			assertEquals(gen.getMaximoBeneficio(primeraCarga, PESO_MAXIMO), "Lisboa");
		} catch (ExceedMaxWeightException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Test(expected = ExceedMaxWeightException.class)
	public void shouldReturnException() throws ExceedMaxWeightException{
		int[] primeraCarga = new int[]{51, 100, 50};
		
		Generador gen = new Generador();
		
		gen.getMaximoBeneficio(primeraCarga, PESO_MAXIMO);
		
	}
}
