package com.trifulcas.examen;

public class Procesados extends Alimento {

	public Procesados(String nombre, int calorias) {
		super(nombre, calorias);
		setFactor(1.4);
	}

	@Override
	public double valorNutricional(int cantidad) {

		return getCalorias()*getFactor()*cantidad+cantidad/4;
	}

}
