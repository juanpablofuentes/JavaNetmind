package com.trifulcas.examen;

public class Complejo {

	private double real;
	private double imaginaria;
	
	public Complejo(double real, double imaginaria) {
		super();
		this.real = real;
		this.imaginaria = imaginaria;
	}
	


	/**
	 * @return the real
	 */
	public double getReal() {
		return real;
	}
	/**
	 * @param real the real to set
	 */
	public void setReal(double real) {
		this.real = real;
	}
	/**
	 * @return the imaginaria
	 */
	public double getImaginaria() {
		return imaginaria;
	}
	/**
	 * @param imaginaria the imaginaria to set
	 */
	public void setImaginaria(double imaginaria) {
		this.imaginaria = imaginaria;
	}
	@Override
	public String toString() {
		return  getReal() + "+" + getImaginaria() + "i";
	}
	
	public double modulo() {
		return Math.sqrt(getReal()*getReal()+getImaginaria()*getImaginaria());
		//return Math.sqrt(Math.pow(getReal()*,2)+Math.pow(getImaginaria(),2));
	}
	
}

class Foo{
	public String nombre;


}