package com.trifulcas.preexamen;

public class TestPreExamen {

	public static void main(String[] args) {
		Televisor lg = new Televisor("lg", 40, 100);
		System.out.println(lg);
		System.out.println(lg.getDiagonal());
		
		Ordenador dell=new Ordenador("Dell",10,10,"AMD");
		System.out.println(dell);
		
		Lavavajillas braun=new Lavavajillas("Braun",200);
		System.out.println(braun);
		System.out.println(braun.getDiagonal());
		System.out.println(braun.getPeso());
		
		Pale pale=new Pale(3000,700);
		pale.addPaquete(braun);
		pale.addPaquete(dell);
		pale.addPaquete(lg);
		System.out.println(pale);
		
		pale.fueraTelevisores();
		System.out.println(pale);
	}

}
