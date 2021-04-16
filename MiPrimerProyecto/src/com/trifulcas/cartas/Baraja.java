package com.trifulcas.cartas;

import java.util.ArrayList;
import java.util.List;

public class Baraja implements JuegoAzar {
	private List<Carta> cartas;

	public Baraja() {
		cartas = new ArrayList<Carta>();
	}

	public void addCarta(Carta carta) {
		if (carta instanceof Francesa) {
			Francesa temp=(Francesa)carta;
			temp.quienSoy();
		}
		cartas.add(carta);
	}

	public int totalValor() {
		int res = 0;
		for (Carta carta : cartas) {
			res += carta.getValor();
		}
		return res;
	}

	public String toString() {
		String res = "";
		for (Carta carta : cartas) {
			res += carta + " - ";
		}
		return res;
	}

	@Override
	public void mezclar() {
		System.out.println("Mezclando las cartas");
		
	}
}
