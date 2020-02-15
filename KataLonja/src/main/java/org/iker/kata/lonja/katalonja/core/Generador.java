package org.iker.kata.lonja.katalonja.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.logging.log4j.*;
import org.iker.kata.lonja.katalonja.dominio.Mercado;
import org.iker.kata.lonja.katalonja.estatico.GastosFijos;
import org.iker.kata.lonja.katalonja.excepciones.ExceedMaxWeightException;
import org.iker.kata.lonja.katalonja.utilidades.Utiles;

public class Generador {

	final static Logger log = LogManager.getLogger(Generador.class);
	
	public Generador() {
		
	}
	
	public String getMaximoBeneficio(int[] primeraCarga, int pesoMaximo) throws ExceedMaxWeightException{
		
		if(superaPesoMaximo(primeraCarga, pesoMaximo)) {
			throw new ExceedMaxWeightException();
		}
		
		Map<String, Float> beneficiosPorMercado = new HashMap<String, Float>();
		
		List<Mercado> lMercados = Utiles.getListaMercados();
		
		for (Mercado mercado : lMercados) {
			beneficiosPorMercado.put(mercado.getCiudad(), calcularBeneficio(mercado, primeraCarga));
		}
		
		log.debug(beneficiosPorMercado);
		
		Map.Entry<String, Float> maxEntry = null;

		for (Map.Entry<String, Float> entry : beneficiosPorMercado.entrySet())
		{
		    if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
		    {
		        maxEntry = entry;
		    }
		}
		
		return maxEntry.getKey();
	}
	
	private boolean superaPesoMaximo(int[] primeraCarga, int pesoMaximo) {
		int peso = 0;
		for(int t : primeraCarga) {
			peso += t;
		}
		if(peso > pesoMaximo) {
			return true;
		}
		return false;
		
	}

	private Float calcularBeneficio(Mercado mercado, int[] primeraCarga) {
		float beneficio = calcularBeneficioVenta(mercado, primeraCarga) - calcularGastoFijoYPorKm(mercado);
		return beneficio;
	}
	
	private float calcularBeneficioVenta(Mercado mercado, int[] primeraCarga) {
		log.debug(mercado.getCiudad());
//		log.debug(depreciacionProducto(mercado.getVieiras(), mercado.getDistancia()));
		log.debug(depreciacionProducto(mercado.getVieiras(), mercado.getDistancia()) * primeraCarga[0]);
		log.debug(depreciacionProducto(mercado.getPulpo(), mercado.getDistancia()) * primeraCarga[1]);
		log.debug(depreciacionProducto(mercado.getCentollos(), mercado.getDistancia()) * primeraCarga[2]);
		
		return (depreciacionProducto(mercado.getVieiras(), mercado.getDistancia()) * primeraCarga[0]) +
				(depreciacionProducto(mercado.getPulpo(), mercado.getDistancia()) * primeraCarga[1]) +
						(depreciacionProducto(mercado.getCentollos(), mercado.getDistancia()) * primeraCarga[2]);
	}

	private int calcularGastoFijoYPorKm(Mercado mercado) {
		return GastosFijos.CARGAR_FURGONETA + (mercado.getDistancia() * GastosFijos.GASTO_POR_KM);
	}
	
	private float depreciacionProducto(float precio, int km) {
		float depreciacionPorKm = km/100;
		log.debug((float)precio - (precio * depreciacionPorKm * GastosFijos.PORCENTAJE_DEPRECIACION_POR_100_KM/100 ));
		return precio - (precio * depreciacionPorKm * GastosFijos.PORCENTAJE_DEPRECIACION_POR_100_KM / 100);
	}
	
	
	
}
