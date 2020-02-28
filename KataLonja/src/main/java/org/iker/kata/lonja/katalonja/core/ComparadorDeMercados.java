package org.iker.kata.lonja.katalonja.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.iker.kata.lonja.katalonja.dominio.Mercado;
import org.iker.kata.lonja.katalonja.dominio.Producto;
import org.iker.kata.lonja.katalonja.dominio.Vehiculo;
import org.iker.kata.lonja.katalonja.estatico.GastosFijos;
import org.iker.kata.lonja.katalonja.excepciones.ExceedMaxWeightException;
import org.iker.kata.lonja.katalonja.service.MercadoService;
import org.iker.kata.lonja.katalonja.utilidades.UtilesLista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComparadorDeMercados {

	final static Logger log = LogManager.getLogger(ComparadorDeMercados.class);

	@Autowired
	private MercadoService mercadoService;
	
	private Vehiculo camion;

//	public ComparadorDeMercados(Vehiculo camion) {
//		this.camion = camion;
//	}
	
	public void setVehiculo(Vehiculo camion) {
		this.camion = camion;
	}


	public String getMaximoBeneficio(List<Producto> primeraCarga) throws ExceedMaxWeightException {

		if (superaPesoMaximo(primeraCarga)) {
			throw new ExceedMaxWeightException();
		}

		Map<String, Float> beneficiosPorMercado = new HashMap<String, Float>();

		List<Mercado> lMercados = mercadoService.getMercadosInfo();

		for (Mercado mercado : lMercados) {
			beneficiosPorMercado.put(mercado.getCiudad(), calcularBeneficio(mercado, primeraCarga));
		}

		log.debug(beneficiosPorMercado);

		Map.Entry<String, Float> maxEntry = null;

		for (Map.Entry<String, Float> entry : beneficiosPorMercado.entrySet()) {
			if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
				maxEntry = entry;
			}
		}

		return maxEntry.getKey();
	}

	private boolean superaPesoMaximo(List<Producto> primeraCarga) {
		int peso = 0;
		for (Producto t : primeraCarga) {
			peso += t.getPeso();
		}
		if (peso > camion.getPesomaximoSoportado()) {
			log.error("El peso excede el máximo permitido");
			return true;
		}
		return false;

	}

	private Float calcularBeneficio(Mercado mercado, List<Producto> primeraCarga) {
		float beneficio = calcularBeneficioVenta(mercado, primeraCarga) - calcularGastoFijoYPorKm(mercado);
		return beneficio;
	}

	private float calcularBeneficioVenta(Mercado mercado, List<Producto> primeraCarga) {
		Float beneficio = 0.0f;
		for (Producto pro : primeraCarga) {
			beneficio += depreciacionProducto(
					UtilesLista.getPescadoByName(mercado.getArticulos(), pro.getNombre()).getPrecio(),
					mercado.getDistancia()) * pro.getPeso();
		}

		return beneficio;
	}

	private int calcularGastoFijoYPorKm(Mercado mercado) {
		return GastosFijos.CARGAR_FURGONETA + (mercado.getDistancia() * GastosFijos.GASTO_POR_KM);
	}

	private float depreciacionProducto(float precio, int km) {
		float depreciacionPorKm = km / 100;
		return precio - (precio * depreciacionPorKm * GastosFijos.PORCENTAJE_DEPRECIACION_POR_100_KM / 100);
	}

	public void setMercadoService(MercadoService mercadoService) {
		this.mercadoService = mercadoService;
	}

}
