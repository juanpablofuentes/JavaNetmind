package com.trifulcas.examen;

public class Carnes extends Alimento {

	public Carnes(String nombre, int calorias) {
		super(nombre, calorias);
		setFactor(0.9);
	}

	@Override
	public double valorNutricional(int cantidad) {
		
		return getCalorias()*getFactor()*cantidad+cantidad/10;
	}

	@Override
	public String toString() {
		return "Carnes " + super.toString() ;
	}

}
