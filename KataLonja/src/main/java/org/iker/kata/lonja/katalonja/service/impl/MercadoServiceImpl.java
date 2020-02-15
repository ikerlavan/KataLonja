package org.iker.kata.lonja.katalonja.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.iker.kata.lonja.katalonja.dominio.Mercado;
import org.iker.kata.lonja.katalonja.estatico.Mercados;
import org.iker.kata.lonja.katalonja.service.MercadoService;

public class MercadoServiceImpl implements MercadoService {

	@Override
	public List<Mercado> getMercadosInfo() {
		
		List<Mercado> lMercados = new ArrayList<Mercado>();
		
		lMercados.add(new Mercado(Mercados.LISBOA.getCiudad(), Mercados.LISBOA.getDistancia(), 
				Mercados.LISBOA.getVieiras(), Mercados.LISBOA.getPulpo(), 
				Mercados.LISBOA.getCentollos()));
		lMercados.add(new Mercado(Mercados.BARCELONA.getCiudad(), Mercados.BARCELONA.getDistancia(), 
				Mercados.BARCELONA.getVieiras(), Mercados.BARCELONA.getPulpo(), 
				Mercados.BARCELONA.getCentollos()));
		lMercados.add(new Mercado(Mercados.MADRID.getCiudad(), Mercados.MADRID.getDistancia(), 
				Mercados.MADRID.getVieiras(), Mercados.MADRID.getPulpo(), 
				Mercados.MADRID.getCentollos()));
		
		return lMercados;
	}

}
