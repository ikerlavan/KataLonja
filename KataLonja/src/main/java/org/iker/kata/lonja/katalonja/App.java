package org.iker.kata.lonja.katalonja;

import java.io.ObjectInputStream.GetField;

import org.apache.logging.log4j.*;
import org.iker.kata.lonja.katalonja.core.Generador;
import org.iker.kata.lonja.katalonja.excepciones.ExceedMaxWeightException;


public class App 
{
	final static Logger log = LogManager.getLogger(App.class);
	
	private static final int PESO_MAXIMO = 200;
	
    public static void main( String[] args ) throws ExceedMaxWeightException
    {
        log.debug( "Hello World!" );
        
        /*El array de primera carga: vieiras, pulpo, centollo*/
    	int[] primeraCarga = new int[]{50, 100, 50};
    	
        Generador generador = new Generador();
        String mercadoMasBeneficioso = generador.getMaximoBeneficio(primeraCarga, PESO_MAXIMO);
        
        log.debug(mercadoMasBeneficioso);
        
        
    }
}
