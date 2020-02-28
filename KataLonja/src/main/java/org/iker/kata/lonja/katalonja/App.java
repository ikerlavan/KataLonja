package org.iker.kata.lonja.katalonja;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.iker.kata.lonja.katalonja.core.ComparadorDeMercados;
import org.iker.kata.lonja.katalonja.dominio.Producto;
import org.iker.kata.lonja.katalonja.dominio.Vehiculo;
import org.iker.kata.lonja.katalonja.estatico.Articulo;
import org.iker.kata.lonja.katalonja.excepciones.ExceedMaxWeightException;
import org.iker.kata.lonja.katalonja.service.impl.MercadoServiceImpl;
import org.springframework.boot.CommandLineRunner;

public class App {
	private static final Logger log = LogManager.getLogger(App.class);

	private static final int PESO_MAXIMO = 200;

	
}
