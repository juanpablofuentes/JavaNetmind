package com.trifulcas.cartas;

import java.util.ArrayList;
import java.util.List;

public class TestCartas {

	public static void main(String[] args) {
		Carta sotabastos = new Espanyola();
		sotabastos.setPalo("Bastos");
		sotabastos.setNumero(10);
		System.out.println(sotabastos);
		
		
		Carta sietepicas = new Francesa();
		sietepicas.setNumero(7);
		sietepicas.setPalo("Picas");
		System.out.println(sietepicas);
		((Francesa)sietepicas).quienSoy();

		Francesa cuatrotreboles=new Francesa();
		cuatrotreboles.setNumero(4);
		cuatrotreboles.setPalo("Treboles");
		cuatrotreboles.quienSoy();
		
		Carta reyespadas = new Espanyola();
		reyespadas.setPalo("Espadas");
		reyespadas.setNumero(12);
		System.out.println(reyespadas);

		Baraja miBaraja = new Baraja();
		miBaraja.addCarta(sietepicas);
		miBaraja.addCarta(sotabastos);
		miBaraja.addCarta(reyespadas);
		miBaraja.addCarta(cuatrotreboles);
		
		System.out.println(miBaraja);
		System.out.println(miBaraja.totalValor());
		
		JuegoAzar[] juegos= {new Baraja(),new Domino()};
		
		for(JuegoAzar juego:juegos) {
			if (juego instanceof Domino) {
				((Domino) juego).esDomino();
			}
			juego.mezclar();
		}
	
	}

}
