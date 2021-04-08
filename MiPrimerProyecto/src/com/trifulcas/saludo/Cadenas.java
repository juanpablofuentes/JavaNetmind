package com.trifulcas.saludo;

public class Cadenas {
	public static void main(String[] args) {
		String[] alumnos= {"Ana","Eva","Juan"};
		String al="Eva";
		for(String n:alumnos) {
			if (n==al) {
				System.out.println("SI");
			}
		}
	}
}
