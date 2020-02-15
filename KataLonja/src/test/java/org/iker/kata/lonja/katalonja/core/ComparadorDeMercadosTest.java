package org.iker.kata.lonja.katalonja.core;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.iker.kata.lonja.katalonja.dominio.Mercado;
import org.iker.kata.lonja.katalonja.excepciones.ExceedMaxWeightException;
import org.iker.kata.lonja.katalonja.service.MercadoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ComparadorDeMercadosTest {
	private static final int PESO_MAXIMO = 200;

	@InjectMocks
	private ComparadorDeMercados comparadorDeMercados;
	
	@Mock
	private MercadoService mercadoService;

	@Test
	public void shouldBeLisboaBestBenefit() {
		int[] primeraCarga = new int[] { 50, 100, 50 };

		List<Mercado> lMercados = Arrays.asList(new Mercado("Lisboa", 600, 600, 100, 500),
				new Mercado("Barcelona", 1100, 450, 120, 0), new Mercado("Madrid", 800, 500, 0, 450));
		
		when(mercadoService.getMercadosInfo()).thenReturn(lMercados);
		
		String ciudad = "Lisboa";
		try {
			String c = comparadorDeMercados.getMaximoBeneficio(primeraCarga, PESO_MAXIMO);
			System.out.println(c);
			assertEquals(c, ciudad);
		} catch (ExceedMaxWeightException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(expected = ExceedMaxWeightException.class)
	public void shouldReturnException() throws ExceedMaxWeightException {
		int[] primeraCarga = new int[] { 51, 100, 50 };

		ComparadorDeMercados gen = new ComparadorDeMercados();

		gen.getMaximoBeneficio(primeraCarga, PESO_MAXIMO);

	}

	@Test
	public void shouldBeMadridBestBenefit() {
		int[] primeraCarga = new int[] { 50, 100, 50 };

		List<Mercado> lMercados = Arrays.asList(new Mercado("Lisboa", 600, 0, 100, 200),
				new Mercado("Barcelona", 1100, 100, 200, 0), new Mercado("Madrid", 800, 600, 200, 400));

		when(mercadoService.getMercadosInfo()).thenReturn(lMercados);

		String ciudad = "Madrid";
		try {
			String c = comparadorDeMercados.getMaximoBeneficio(primeraCarga, PESO_MAXIMO);
			System.out.println(c);
			assertEquals(c, ciudad);
		} catch (ExceedMaxWeightException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
