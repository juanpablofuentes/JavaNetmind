package com.trifulcas.datos;

public class Moneda {

	private int idmonedas;
	private String nombre;
	private double valor;
	public Moneda(int idmonedas, String nombre, double valor) {
		super();
		this.idmonedas = idmonedas;
		this.nombre = nombre;
		this.valor = valor;
	}
	/**
	 * @return the idmonedas
	 */
	public int getIdmonedas() {
		return idmonedas;
	}
	/**
	 * @param idmonedas the idmonedas to set
	 */
	public void setIdmonedas(int idmonedas) {
		this.idmonedas = idmonedas;
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
	 * @return the valor
	 */
	public double getValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}
	@Override
	public String toString() {
		return "Moneda [idmonedas=" + idmonedas + ", nombre=" + nombre + ", valor=" + valor + "]";
	}
	
	
}
