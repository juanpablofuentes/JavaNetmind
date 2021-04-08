package com.trifulcas.ejercitos;

public class Capitan extends Infanteria {

	public Capitan() {
		setNombre("Capit�n");
		setFortaleza(70);
		setDanyo(10);
		setArmadura(40);
	}

	@Override
	public void cargar() {
		System.out.println("Ataque de capit�n "+getDanyo());
	}

	@Override
	public void retroceder() {
		System.out.println("��Retirada!!!!");
		setFortaleza(getFortaleza()-5);
		setDanyo(getDanyo()-2);
	}

}
