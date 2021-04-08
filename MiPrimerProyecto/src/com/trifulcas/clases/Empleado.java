package com.trifulcas.clases;

public class Empleado {
	private String nombre;
	private String dni;
	private double sueldo;

	public Empleado(String nombre, String dni, double sueldo) {
		// super: hace referencia a la clase madre
		// Dentro de la OOP en general siempre dentro de un constructor
		// Se llama al constructor de la clase madre si la hay
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.sueldo = sueldo;
	}

	public void saludo() {
		System.out.println("Hola que tal");
	}
	public double sueldoNeto() {
		if (sueldo<1000) {
			return sueldo * .9;	
		}else {
			return sueldo * .85;
		}
		
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the sueldo
	 */
	public double getSueldo() {
		return sueldo;
	}

	/**
	 * @param sueldo the sueldo to set
	 */
	public void setSueldo(double sueldo) {
		if (sueldo >= 650) {
			this.sueldo = sueldo;
		}
	}

}
