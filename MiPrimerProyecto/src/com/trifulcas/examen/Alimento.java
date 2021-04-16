package com.trifulcas.examen;

public abstract class Alimento {
	private String nombre;
	private int calorias;
	private double factor;
	
	
	public Alimento(String nombre, int calorias) {
		super();
		this.nombre = nombre;
		this.calorias = calorias;
	}
	
	public abstract double valorNutricional(int cantidad);
	
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
	 * @return the calorias
	 */
	public int getCalorias() {
		return calorias;
	}
	/**
	 * @param calorias the calorias to set
	 */
	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}
	/**
	 * @return the factor
	 */
	public double getFactor() {
		return factor;
	}
	/**
	 * @param factor the factor to set
	 */
	public void setFactor(double factor) {
		this.factor = factor;
	}

	@Override
	public String toString() {
		return "Alimento [nombre=" + nombre + ", calorias=" + calorias + ", factor=" + factor + "]";
	}
	
	
}
