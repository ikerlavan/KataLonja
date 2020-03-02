package org.iker.kata.lonja.katalonja.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.iker.kata.lonja.katalonja.dominio.Mercado;
import org.iker.kata.lonja.katalonja.dominio.Pescado;
import org.iker.kata.lonja.katalonja.estatico.Articulo;
import org.iker.kata.lonja.katalonja.service.MercadoService;
import org.springframework.stereotype.Component;

@Component
public class MercadoServiceImpl implements MercadoService {

	@Override
	public List<Mercado> getMercadosInfo() {
		
		List<Mercado> lMercados = new ArrayList<>();
		
		List<Pescado> pescados = Arrays.asList(new Pescado(Articulo.VIEIRAS.getNombre(), 600),
												new Pescado(Articulo.PULPO.getNombre(), 100),
												new Pescado(Articulo.CENTOLLO.getNombre(), 500));
		Mercado lisboa = new Mercado("Lisboa",600, pescados);
		lMercados.add(lisboa);
				
		pescados = Arrays.asList(new Pescado(Articulo.VIEIRAS.getNombre(), 450),
				new Pescado(Articulo.PULPO.getNombre(), 120),
				new Pescado(Articulo.CENTOLLO.getNombre(), 0));
		Mercado bcn = new Mercado("Barcelona",1100, pescados);
		lMercados.add(bcn);
		
		pescados = Arrays.asList(new Pescado(Articulo.VIEIRAS.getNombre(), 500),
				new Pescado(Articulo.PULPO.getNombre(), 0),
				new Pescado(Articulo.CENTOLLO.getNombre(), 450));
		Mercado madrid = new Mercado("Madrid",800, pescados);
		
		lMercados.add(madrid);
		
		
		return lMercados;
	}

}
