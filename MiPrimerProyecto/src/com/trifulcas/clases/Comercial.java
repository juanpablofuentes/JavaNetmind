package com.trifulcas.clases;

public class Comercial extends Empleado {

	private double ventas;
	private double comision;

	public Comercial(String nombre, String dni, double sueldo) {
		// super: Hace referencia a la clase madre
		super(nombre, dni, sueldo);
	}
	
	public void hola(double ventas) {
	
		super.saludo();
		
	}
	
	public double sueldoNeto() {
		// sueldo multiplicado * 0.9 + ventas * comision
		// No tengo acceso a sueldo
		// a) Cambiar visibilidad de sueldo a protected
		// b) Usar getSueldo()
		// c) Usar la función de la clase madre
		return super.sueldoNeto()+ventas*comision;
	}
	
	/**
	 * @return the ventas
	 */
	public double getVentas() {
		return ventas;
	}


	/**
	 * @param ventas the ventas to set
	 */
	public void setVentas(double ventas) {
		this.ventas = ventas;
	}


	/**
	 * @return the comision
	 */
	public double getComision() {
		return comision;
	}


	/**
	 * @param comision the comision to set
	 */
	public void setComision(double comision) {
		this.comision = comision;
	}



}
