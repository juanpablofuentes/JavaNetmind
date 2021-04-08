package com.trifulcas.saludo;

public class Ambito {

	public static void main(String[] args) {
		// x está definida para todo el bloque, incluyendo subbloques
		int x=0;
		
		for(int i=0;i<10;i++) {
			// i y nombre sólo están definidas dentro de este bloque
			String nombre="Juan";
			System.out.println(i);
			System.out.println(nombre);
			System.out.println(x);
		}
		// x existe
		System.out.println(x);
		// Pero i y nombre no porque se ha cerrado el bloque en el que
		// estaban definidas
//		System.out.println(i);
//		System.out.println(nombre);

	}

}
