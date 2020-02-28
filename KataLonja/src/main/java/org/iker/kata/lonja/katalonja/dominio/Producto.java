package org.iker.kata.lonja.katalonja.dominio;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Producto {

	
	public Producto(String nombre, int peso) {
		super();
		this.nombre = nombre;
		this.peso = peso;
	}
	private String nombre;
	private int peso;
	
	public String getNombre() {
		return nombre;
	}
	public int getPeso() {
		return peso;
	}
	public void setNombre(String name) {
		this.nombre = name;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
}
