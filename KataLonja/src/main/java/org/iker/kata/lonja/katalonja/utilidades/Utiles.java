package org.iker.kata.lonja.katalonja.utilidades;

import java.util.ArrayList;
import java.util.List;

import org.iker.kata.lonja.katalonja.dominio.Mercado;
import org.iker.kata.lonja.katalonja.estatico.Mercados;

public class Utiles {
	
	public static List<Mercado> getListaMercados(){
		List<Mercado> lMercados = new ArrayList<Mercado>();
		
		lMercados.add(new Mercado(Mercados.LISBOA));
		lMercados.add(new Mercado(Mercados.BARCELONA));
		lMercados.add(new Mercado(Mercados.MADRID));
		
		return lMercados;
		
		
	}

}
