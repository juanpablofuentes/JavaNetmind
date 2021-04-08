package com.trifulcas.saludo;

public class Ejercicio3 {

	public static void main(String[] args) {
		System.out.println(arbol("hola"));
		System.out.println(arbol("J"));
		System.out.println(arbol("@"));
		System.out.println(arbol("@", 3));
		System.out.println(arbol("@", 8));
	}

	public static double iva(double precio) {
		return iva(precio,.21);
	}
	public static double iva(double precio,double iva) {
		return precio*(1+iva);
	}
	
	public static String arbol(String cadena) {
		return arbol(cadena, 5);
	}

	public static String arbol(String cadena, int veces) {
		if (cadena.length() != 1) {
			return cadena;
		}
		String res = "";
		for (int i = 0; i < veces; i++) {
			res += repetir(cadena, i + 1) + "\n";
		}
		return res;
	}

	public static String repetir(String cadena, int veces) {
		String res = "";
		for (int i = 0; i < veces; i++) {
			res += cadena;
		}
		return res;
	}
}
