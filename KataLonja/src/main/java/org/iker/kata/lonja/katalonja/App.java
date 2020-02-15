package org.iker.kata.lonja.katalonja;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.iker.kata.lonja.katalonja.core.ComparadorDeMercados;
import org.iker.kata.lonja.katalonja.excepciones.ExceedMaxWeightException;


public class App 
{
	private static final Logger log = LogManager.getLogger(App.class);
	
	private static final int PESO_MAXIMO = 200;
	
    public static void main( String[] args ) throws ExceedMaxWeightException
    {
        log.info( "Hello World!" );
        
        /*El array de primera carga: vieiras, pulpo, centollo*/
    	int[] primeraCarga = new int[]{50, 100, 50};
    	
        ComparadorDeMercados generador = new ComparadorDeMercados();
//        generador.setMercadoService(new MercadoServiceImpl());
        String mercadoMasBeneficioso = generador.getMaximoBeneficio(primeraCarga, PESO_MAXIMO);
        
        log.info("El mercado que más beneficios va a ofrecer es el de {}", mercadoMasBeneficioso);
        
        
    }
}
