package com.trifulcas.cartas;

public abstract class Carta {
	private String palo;
	private int numero;

	public abstract int getValor();
	
	/**
	 * @return the palo
	 */
	public String getPalo() {
		return palo;
	}

	/**
	 * @param palo the palo to set
	 */
	public void setPalo(String palo) {
		this.palo = palo;
	}

	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String toString() {
		return palo+" | "+numero;
	}
}
