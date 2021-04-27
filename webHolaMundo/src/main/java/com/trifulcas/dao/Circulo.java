package com.trifulcas.dao;

public class Circulo {

	private double radio;

	/**
	 * @return the radio
	 */
	public double getRadio() {
		return radio;
	}

	/**
	 * @param radio the radio to set
	 */
	public void setRadio(double radio) {
		this.radio = radio;
	}

	public Circulo(double radio) {
		super();
		this.radio = radio;
	}
	
	public double getArea() {
		return Math.PI*radio*radio;
	}
	
	public double diametro() {
		return Math.PI*2*radio;
	}
	
}
