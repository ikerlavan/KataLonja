package org.iker.kata.lonja.katalonja.dominio;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

public class Mercado {

	private String ciudad;
	private int distancia;
	private List<Pescado> articulos;
	
//	private float pulpo;
//	private float centollos;
	
	public Mercado(String ciudad, int distancia, List<Pescado> articulos) {
		this.setCiudad(ciudad);
		this.setDistancia(distancia);
		this.setArticulos(articulos);
	}
	
	public String getCiudad() {
		return ciudad;
	}
	public int getDistancia() {
		return distancia;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public List<Pescado> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<Pescado> lArticulo) {
		this.articulos = lArticulo;
	}

}
