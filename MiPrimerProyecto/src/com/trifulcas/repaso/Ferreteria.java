package com.trifulcas.repaso;

public class Ferreteria extends Componente {

	public Ferreteria(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String referencia() {
		// TODO Auto-generated method stub
		return getNombre().substring(0,2);
	}

}
