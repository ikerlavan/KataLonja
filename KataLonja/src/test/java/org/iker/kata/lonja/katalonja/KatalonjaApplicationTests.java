package org.iker.kata.lonja.katalonja;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.iker.kata.lonja.katalonja.core.ComparadorDeMercados;
import org.iker.kata.lonja.katalonja.dominio.Mercado;
import org.iker.kata.lonja.katalonja.dominio.Pescado;
import org.iker.kata.lonja.katalonja.dominio.Producto;
import org.iker.kata.lonja.katalonja.dominio.Vehiculo;
import org.iker.kata.lonja.katalonja.estatico.Articulo;
import org.iker.kata.lonja.katalonja.excepciones.ExceedMaxWeightException;
import org.iker.kata.lonja.katalonja.service.MercadoService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class KatalonjaApplicationTests {

	@Test
	void contextLoads() {
	}

	private static final int PESO_MAXIMO = 200;

	@InjectMocks
	private ComparadorDeMercados comparadorDeMercado;

	@Mock
	private MercadoService mercadoService;

	@BeforeEach
	public void setup() {
		comparadorDeMercado.setVehiculo(new Vehiculo(PESO_MAXIMO));
	}

	@Test
	@DisplayName("Debería retornar Lisboa")
	public void shouldBeLisboaBestBenefit() {
		
		when(mercadoService.getMercadosInfo()).thenReturn(getListaMercados());

		String ciudad = "Lisboa";
		
		try {
			assertEquals(comparadorDeMercado.getMaximoBeneficio(getListaProductos()), ciudad);
		} catch (ExceedMaxWeightException e) {
			e.printStackTrace();
		}

	}

	@Test
	@DisplayName("Debería retornar la excepción ExceedMaxWeightException")
	public void shouldReturnException() {
		
		assertThrows(ExceedMaxWeightException.class, () -> {
			comparadorDeMercado.getMaximoBeneficio(getListaProductosSuperaPesoMaximo());
	    });
	}

	@Test
	@DisplayName("Debería retornar Madrid")
	public void shouldBeMadridBestBenefit() {

		when(mercadoService.getMercadosInfo()).thenReturn(getListaMercadosOtraCiudad());

		String ciudad = "Madrid";
		try {
			assertEquals(comparadorDeMercado.getMaximoBeneficio(getListaProductos()), ciudad);
		} catch (ExceedMaxWeightException e) {
			e.printStackTrace();
		}
	}

	protected List<Producto> getListaProductos() {
		List<Producto> lProductos = new ArrayList<Producto>();
		Producto vieiras = new Producto(Articulo.VIEIRAS.getNombre(), 50);
		Producto pulpo = new Producto(Articulo.PULPO.getNombre(), 100);
		Producto centollo = new Producto(Articulo.CENTOLLO.getNombre(), 50);
		lProductos.add(vieiras);
		lProductos.add(pulpo);
		lProductos.add(centollo);
		return lProductos;
	}

	private List<Producto> getListaProductosSuperaPesoMaximo() {
		List<Producto> lProductos = new ArrayList<Producto>();
		Producto vieiras = new Producto(Articulo.VIEIRAS.getNombre(), 51);
		Producto pulpo = new Producto(Articulo.PULPO.getNombre(), 100);
		Producto centollo = new Producto(Articulo.CENTOLLO.getNombre(), 50);
		lProductos.add(vieiras);
		lProductos.add(pulpo);
		lProductos.add(centollo);
		return lProductos;
	}

	protected List<Mercado> getListaMercados() {
		List<Mercado> lMercados = new ArrayList<Mercado>();

		List<Pescado> pescados = Arrays.asList(new Pescado(Articulo.VIEIRAS.getNombre(), 600),
				new Pescado(Articulo.PULPO.getNombre(), 100), new Pescado(Articulo.CENTOLLO.getNombre(), 500));
		Mercado lisboa = new Mercado("Lisboa", 600, pescados);
		lMercados.add(lisboa);

		pescados = Arrays.asList(new Pescado(Articulo.VIEIRAS.getNombre(), 450),
				new Pescado(Articulo.PULPO.getNombre(), 120), new Pescado(Articulo.CENTOLLO.getNombre(), 0));
		Mercado bcn = new Mercado("Barcelona", 1100, pescados);
		lMercados.add(bcn);

		pescados = Arrays.asList(new Pescado(Articulo.VIEIRAS.getNombre(), 500),
				new Pescado(Articulo.PULPO.getNombre(), 0), new Pescado(Articulo.CENTOLLO.getNombre(), 450));
		Mercado madrid = new Mercado("Madrid", 800, pescados);

		lMercados.add(madrid);

		return lMercados;
	}

	private List<Mercado> getListaMercadosOtraCiudad() {
		List<Mercado> lMercados = new ArrayList<Mercado>();

		List<Pescado> pescados = Arrays.asList(new Pescado(Articulo.VIEIRAS.getNombre(), 400),
				new Pescado(Articulo.PULPO.getNombre(), 0), new Pescado(Articulo.CENTOLLO.getNombre(), 500));

		Mercado lisboa = new Mercado("Lisboa", 600, pescados);
		lMercados.add(lisboa);

		pescados = Arrays.asList(new Pescado(Articulo.VIEIRAS.getNombre(), 450),
				new Pescado(Articulo.PULPO.getNombre(), 120), new Pescado(Articulo.CENTOLLO.getNombre(), 0));

		Mercado bcn = new Mercado("Barcelona", 1100, pescados);
		lMercados.add(bcn);

		pescados = Arrays.asList(new Pescado(Articulo.VIEIRAS.getNombre(), 500),
				new Pescado(Articulo.PULPO.getNombre(), 200), new Pescado(Articulo.CENTOLLO.getNombre(), 600));

		Mercado madrid = new Mercado("Madrid", 800, pescados);

		lMercados.add(madrid);

		return lMercados;
	}
}
