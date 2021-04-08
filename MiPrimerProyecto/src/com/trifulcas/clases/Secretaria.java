package com.trifulcas.clases;

final public class Secretaria extends Administrativo {
	
	private int posicion;
	
	public Secretaria(String nombre, String dni, double sueldo, int antiguedad) {
		// Hace referencia a la clase madre Administrativo
		super(nombre, dni, sueldo, antiguedad);
		this.posicion=10;
	}

	// A�adir aqu� una sobreescritura de sueldoNeto que sea:
	// sueldoneto +sueldo*antiguedad/100 + posicion*5;
	final public double sueldoNeto() {
		posicion=9;
		return super.sueldoNeto()+posicion*5;
	}
}

// super nos hace referencia a la clase madre

// constructor, propiedades y m�todos
// En el constructor SIEMPRE llamamos al constructor de la clase madre
// En los m�todos se usa sobre todo en la sobrescritura
// Tambi�n sirve para las propiedades aunque no se usa casi nunca

// final nos indica que ya no se puede derivar o sobreescribir nada
// sobre ese elemento
// Una clase final no admite clases derivadas
// Un m�todo final no admite sobreescritura
// Una propiedad final no admite cambios de valor