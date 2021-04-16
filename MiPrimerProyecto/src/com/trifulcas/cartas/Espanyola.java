package com.trifulcas.cartas;

public class Espanyola extends Carta {

	@Override
	public  int getValor() {
		int res = getNumero();

		if (res == 11 || res == 12) {
			res = 10;
		}
		return res;
	}
}
