package org.iker.kata.lonja.katalonja.dominio;

import org.iker.kata.lonja.katalonja.estatico.Mercados;

public class Mercado {

	private String ciudad;
	private int distancia;
	private float vieiras;
	private float pulpo;
	private float centollos;
	private int depreciacion;
	
	public Mercado(Mercados mercado) {
		this.ciudad = mercado.getCiudad();
		this.distancia = mercado.getDistancia();
		this.vieiras = mercado.getVieiras();
		this.pulpo = mercado.getPulpo();
		this.centollos = mercado.getCentollos();
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
	public int getDepreciacion() {
		return depreciacion;
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
	public void setDepreciacion(int depreciacion) {
		this.depreciacion = depreciacion;
	}
	
	
}
