package com.trifulcas.preexamen;

public class Televisor implements Paqueteria {
	private String modelo;
	private int pulgadas;
	private int peso;
	
	
	public Televisor(String modelo, int pulgadas, int peso) {
		super();
		this.modelo = modelo;
		this.pulgadas = pulgadas;
		this.peso = peso;
	}
	/**
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}
	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	/**
	 * @return the pulgadas
	 */
	public int getPulgadas() {
		return pulgadas;
	}
	/**
	 * @param pulgadas the pulgadas to set
	 */
	public void setPulgadas(int pulgadas) {
		this.pulgadas = pulgadas;
	}
	/**
	 * @return the peso
	 */
	public int getPeso() {
		return peso;
	}
	/**
	 * @param peso the peso to set
	 */
	public void setPeso(int peso) {
		this.peso = peso;
	}
	@Override
	public String toString() {
		return "Televisor [modelo=" + modelo + ", pulgadas=" + pulgadas + ", peso=" + peso + "]";
	}
	@Override
	public int getDiagonal() {
		// TODO Auto-generated method stub
		return getPulgadas()*5;
	}
	

}
