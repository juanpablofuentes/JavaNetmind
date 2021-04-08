package com.trifulcas.ejercitos;

public class Lancero extends Infanteria {

	public Lancero() {
		setNombre("Lancero");
		setFortaleza(60);
		setDanyo(15);
		setArmadura(10);
	}

	@Override
	public void cargar() {
		System.out.println("Ataque de lanceros "+getDanyo());
	}
	public void ataqueLanza() {
		System.out.println("Ataque con lanza "+getDanyo());
	}

	@Override
	public void retroceder() {
		System.out.println("¡¡Retirada!!!!");
		// Si usamos el setter para modificar el valor centralizamos
		// la modificación y es más fácil controlar las restricciones
		setFortaleza(getFortaleza()-4);
		setDanyo(getDanyo()-2);
	}

}
