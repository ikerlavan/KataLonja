package org.iker.kata.lonja.katalonja.utilidades;

import java.util.List;

import org.iker.kata.lonja.katalonja.dominio.Pescado;
import org.iker.kata.lonja.katalonja.dominio.Producto;

public class UtilesLista {

	public static Producto getProductoByName(List<Producto> lProductos, String name) {
		return lProductos.stream().filter(p -> p.getNombre().equals(name)).findFirst().get();
	}
	
	public static Pescado getPescadoByName(List<Pescado> lPescado, String name) {
		return lPescado.stream().filter(p -> p.getNombre().equals(name)).findFirst().get();
	}
	
}
