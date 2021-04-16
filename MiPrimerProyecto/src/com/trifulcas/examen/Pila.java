package com.trifulcas.examen;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pila {

	List<Estadisticas> pila;
	int minutosDiarios;

	public Pila() {
		pila = new ArrayList<Estadisticas>();
		minutosDiarios = 60; // A efectos de prueba no se pide en el enunciado
	}

	public void addItem(Estadisticas el) {
		pila.add(el);
	}

	public double totalTiempo() {
		double res = 0;
		for (Estadisticas item : pila) {
			res += item.tiempoLectura();
		}
		return res;
	}

	@Override
	public String toString() {
		return "Pila [pila=" + pila + ", minutosDiarios=" + minutosDiarios + "]";
	}

	public LocalDate fechaFin() {
		LocalDate fecha = LocalDate.now();

		// totalTiempo()-> Total de minutos que me va a costar leer todo
		// minutosDiarios tengo los minutos que dedico al día
		// total:600 minuto 60: 600/60->10
		// total:30 minutos: 60 0.5
		int dias = (int) Math.floor(totalTiempo() / minutosDiarios);
		return fecha.plusDays(dias);
		
	}
}
