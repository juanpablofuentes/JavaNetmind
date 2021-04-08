package com.trifulcas.clases;

public class Borrame {
public void saludo() {
	System.out.println("Hola");
}
}

class Pepe extends Borrame{
	public void foo() {
		super.saludo();
	}
}