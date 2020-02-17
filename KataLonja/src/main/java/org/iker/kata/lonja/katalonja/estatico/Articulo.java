package org.iker.kata.lonja.katalonja.estatico;

public enum Articulo {
	VIEIRAS("Vieiras"), PULPO("Pulpo"), CENTOLLO("Centollo");

	private String nombre;
	
	private Articulo(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
}
