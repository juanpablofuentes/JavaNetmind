package com.trifulcas.saludo;

import java.util.Scanner;

public class saludo {

	public static void main(String[] args) {
		saludo("Ana", 2);
		saludo("Juan", 3);
		saludo("Eva");
		saludo(3);
		otroSaludo("Eva"); //Esto no hace nada
		//System.out.println(otroSaludo("Eva"));// Esto sí
		int a = doble(7);
		System.out.println(a);
		int b = doble(doble(doble(3)));
		System.out.println(b);
		System.out.println(mayor(1,3));
		System.out.println(mayor(10,3));
	}
	// Side effects efectos colaterales
	static String otroSaludo(String nombre) {
		System.out.println("Hola "+nombre);
		return "Hola "+nombre+" que tal estás";
	}
	// Esto es un método porque no devuelve nada
	static void saludo(String nombre, int n) {
		for (int i = 0; i < n; i++) {
			System.out.println("Hola " + nombre + " que tal");
		}
	}
	// SObre carga (overloading) de funciones. Distintos parámetros
	// Mismo nombre de función
	// Java llamará a la función que 'encaje' con los parámetros
	// Si no encaja ninguna, nos da un error
	// Podemos llamar a funciones entre sobrecargas o no
	static void saludo(String nombre) {
		saludo(nombre,1);
	}
	static void saludo(int n) {
		for (int i = 0; i < n; i++) {
			System.out.println("Hola que tal estás");
		}
	}
	// Esto sí es una función, porque devolvemos un valor
	static int doble(int numero) {
		return numero * 2;
	}

	static int mayor(int a, int b) {
		if (a > b) {
			b = a;
		}
		return b;
	}
}
