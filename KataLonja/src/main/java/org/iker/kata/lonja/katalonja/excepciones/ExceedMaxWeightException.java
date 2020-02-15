package org.iker.kata.lonja.katalonja.excepciones;

public class ExceedMaxWeightException extends Exception {

	private static final long serialVersionUID = -8092543164847481884L;

	// Constructor
    public ExceedMaxWeightException(){};
    
    // Excepcion: Error Provocado
    public String excErrorPersonalizado(){
        return "Supera el peso máximo";
    }

}
