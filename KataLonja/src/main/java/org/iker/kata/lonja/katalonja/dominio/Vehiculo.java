package org.iker.kata.lonja.katalonja.dominio;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
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
