package com.trifulcas.preexamen;

public class Lavavajillas implements Paqueteria {
	private String marca;
	private int capacidad;
	
	
	public Lavavajillas(String marca, int capacidad) {
		super();
		this.marca = marca;
		this.capacidad = capacidad;
	}
	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}
	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}
	/**
	 * @return the capacidad
	 */
	public int getCapacidad() {
		return capacidad;
	}
	/**
	 * @param capacidad the capacidad to set
	 */
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	@Override
	public String toString() {
		return "Lavavajillas [marca=" + marca + ", capacidad=" + capacidad + "]";
	}
	@Override
	public int getPeso() {
		// TODO Auto-generated method stub
		return 200*getCapacidad();
	}
	@Override
	public int getDiagonal() {
		// TODO Auto-generated method stub
		return (int) (getCapacidad()*.7);
	}
	
	
}
