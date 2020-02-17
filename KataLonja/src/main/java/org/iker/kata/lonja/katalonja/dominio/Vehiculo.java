package org.iker.kata.lonja.katalonja.dominio;

public class Vehiculo {

	public Vehiculo(int pesoMaximoSoportado) {
		super();
		this.pesoMaximoSoportado = pesoMaximoSoportado;
	}

	int pesoMaximoSoportado;

	public int getPesomaximoSoportado() {
		return pesoMaximoSoportado;
	}

	public void setPesomaximoSoportado(int pesoMaximoSoportado) {
		this.pesoMaximoSoportado = pesoMaximoSoportado;
	}
}
