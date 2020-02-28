package org.iker.kata.lonja.katalonja.dominio;


public class Pescado {

	public Pescado(String nombre, float precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}
	private String nombre;
	private float precio;
	
	public String getNombre() {
		return nombre;
	}
	public float getPrecio() {
		return precio;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
}
