package com.trifulcas.clases;

public class Super {
	protected String nombre;

	Super(String nombre) {
		this.nombre = nombre;
	}
}

class Derivada extends Super{

	Derivada(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}
		
}