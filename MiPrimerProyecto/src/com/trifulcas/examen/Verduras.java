package com.trifulcas.examen;

public class Verduras extends Alimento {

	public Verduras(String nombre, int calorias) {
		super(nombre, calorias);
		setFactor(0.7);
	}

	@Override
	public double valorNutricional(int cantidad) {
		return getCalorias()*getFactor()*cantidad;
	}
	
	public String tonto() {
		return "Come verduras que sientan muy bien";
	}

}
