package com.trifulcas.cartas;

import java.util.ArrayList;
import java.util.List;

public class Domino implements JuegoAzar{
	List<String> piezas;

	public Domino() {
		piezas = new ArrayList<String>();
	}
	
	public void esDomino() {
		System.out.println("Dominó");
	}

	@Override
	public void mezclar() {
		System.out.println("Mezclando las fichas");

		
	}
}
