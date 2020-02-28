package org.iker.kata.lonja.katalonja;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.iker.kata.lonja.katalonja.core.ComparadorDeMercados;
import org.iker.kata.lonja.katalonja.dominio.Producto;
import org.iker.kata.lonja.katalonja.dominio.Vehiculo;
import org.iker.kata.lonja.katalonja.estatico.Articulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class KatalonjaApplication implements CommandLineRunner {

	@Autowired
	private ComparadorDeMercados generador;
	
	private static final Logger log = LogManager.getLogger(KatalonjaApplication.class);
	private static final int PESO_MAXIMO = 200;
	
	public static void main(String[] args) {
		SpringApplication.run(KatalonjaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		List<Producto> primeraCarga = new ArrayList<Producto>();
		Producto vieiras = new Producto(Articulo.VIEIRAS.getNombre(), 50);
		Producto pulpo = new Producto(Articulo.PULPO.getNombre(), 100);
		Producto centollo = new Producto(Articulo.CENTOLLO.getNombre(), 50);
		primeraCarga.add(vieiras);
		primeraCarga.add(pulpo);
		primeraCarga.add(centollo);

		Vehiculo camion = new Vehiculo(PESO_MAXIMO);

		generador.setVehiculo(camion);
//		generador.setMercadoService(new MercadoServiceImpl());
		String mercadoMasBeneficioso = generador.getMaximoBeneficio(primeraCarga);

		log.info("El mercado que más beneficios va a ofrecer es el de {}", mercadoMasBeneficioso);
	}
}
