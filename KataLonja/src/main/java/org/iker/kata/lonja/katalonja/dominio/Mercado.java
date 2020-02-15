package org.iker.kata.lonja.katalonja.dominio;

import org.iker.kata.lonja.katalonja.estatico.Mercados;

public class Mercado {

	private String ciudad;
	private int distancia;
	private float vieiras;
	private float pulpo;
	private float centollos;
	
	public Mercado(String ciudad, int distancia, float vieiras, float pulpo, float centollos) {
		this.ciudad = ciudad;
		this.distancia = distancia;
		this.vieiras = vieiras;
		this.pulpo = pulpo;
		this.centollos = centollos;
	}
	
	public String getCiudad() {
		return ciudad;
	}
	public int getDistancia() {
		return distancia;
	}
	public float getVieiras() {
		return vieiras;
	}
	public float getPulpo() {
		return pulpo;
	}
	public float getCentollos() {
		return centollos;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
	public void setVieiras(float vieiras) {
		this.vieiras = vieiras;
	}
	public void setPulpo(float pulpo) {
		this.pulpo = pulpo;
	}
	public void setCentollos(float centollos) {
		this.centollos = centollos;
	}
}
