package com.trifulcas.cartas;

public class Francesa extends Carta {

	@Override
	public int getValor() {
		
		return getNumero();
	}
	public void quienSoy() {
		System.out.println("Carta de la baraja Francesa");
	}

}
