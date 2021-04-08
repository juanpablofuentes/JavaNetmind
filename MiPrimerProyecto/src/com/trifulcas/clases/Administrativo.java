package com.trifulcas.clases;

public class Administrativo extends Empleado {

	private int antiguedad;

	public Administrativo(String nombre, String dni, double sueldo, int antiguedad) {
		// super: hace referencia a la clase madre Empleado
		super(nombre, dni, sueldo);
		
		this.antiguedad=antiguedad;
	}

	public double sueldoNeto() {
		// Utilizando por un lado la función de la clase madre
		// Y por otro el acceso público a la propiedad sueldo
		return super.sueldoNeto() + getSueldo() * antiguedad / 100;
	}

	/**
	 * @return the antiguedad
	 */
	public int getAntiguedad() {
		return antiguedad;
	}

	/**
	 * @param antiguedad the antiguedad to set
	 */
	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

}
