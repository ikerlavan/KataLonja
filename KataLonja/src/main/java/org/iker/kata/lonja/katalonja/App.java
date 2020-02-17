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
import org.iker.kata.lonja.katalonja.service.MercadoService;
import org.iker.kata.lonja.katalonja.service.impl.MercadoServiceImpl;


public class App 
{
	private static final Logger log = LogManager.getLogger(App.class);
	
	private static final int PESO_MAXIMO = 200;
	
    public static void main( String[] args ) throws ExceedMaxWeightException
    {
    	List<Producto> primeraCarga = new ArrayList<Producto>();
    	Producto vieiras = new Producto(Articulo.VIEIRAS.getNombre(), 50);
    	Producto pulpo = new Producto(Articulo.PULPO.getNombre(), 100);
    	Producto centollo = new Producto(Articulo.CENTOLLO.getNombre(), 50);
    	primeraCarga.add(vieiras);
    	primeraCarga.add(pulpo);
    	primeraCarga.add(centollo);
    	
    	Vehiculo camion = new Vehiculo(PESO_MAXIMO);
        
    	ComparadorDeMercados generador = new ComparadorDeMercados(camion);
    	generador.setMercadoService(new MercadoServiceImpl());
        String mercadoMasBeneficioso = generador.getMaximoBeneficio(primeraCarga);
        
        log.info("El mercado que más beneficios va a ofrecer es el de {}", mercadoMasBeneficioso);
        
        
    }
}
