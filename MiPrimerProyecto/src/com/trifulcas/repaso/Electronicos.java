package com.trifulcas.repaso;

public class Electronicos extends Componente {

	public Electronicos(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String referencia() {
		// TODO Auto-generated method stub
		return getNombre().substring(0,4);
	}

	public String numSerie() {
		return "123123123";
	}
}
