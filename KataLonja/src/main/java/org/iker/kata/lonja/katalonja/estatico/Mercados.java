package org.iker.kata.lonja.katalonja.estatico;

public enum Mercados {
	LISBOA("Lisboa",600, 600, 100, 500), BARCELONA("Barcelona",1100, 450, 120, 0),
	MADRID("Madrid",800 ,500, 0, 450); 
	
	private String ciudad;
	private int distancia;
	private float vieiras;
	private float pulpo;
	private float centollos;
	
	private Mercados (String ciudad, int distancia, float vieiras, float pulpo, float centollos){
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
	
}
