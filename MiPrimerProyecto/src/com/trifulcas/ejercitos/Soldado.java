package com.trifulcas.ejercitos;

public class Soldado extends Infanteria {

	public Soldado() {
		setNombre("Soldado");
		setFortaleza(50);
		setDanyo(5);
		setArmadura(20);
	}

	@Override
	public void cargar() {
		
		System.out.println("Ataque de soldados "+getDanyo());
	}
	@Override
	public void retroceder() {
		System.out.println("¡¡Retirada!!!!");
		setFortaleza(getFortaleza()-5);
		setDanyo(getDanyo()-1);
	}

}
