package com.trifulcas.saludo;

import java.util.Scanner;

public class saludo {

	public static void main(String[] args) {
		saludo("Ana", 2);
		saludo("Juan", 3);
		saludo("Eva");
		saludo(3);
		otroSaludo("Eva"); //Esto no hace nada
		//System.out.println(otroSaludo("Eva"));// Esto s�
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
		return "Hola "+nombre+" que tal est�s";
	}
	// Esto es un m�todo porque no devuelve nada
	static void saludo(String nombre, int n) {
		for (int i = 0; i < n; i++) {
			System.out.println("Hola " + nombre + " que tal");
		}
	}
	// SObre carga (overloading) de funciones. Distintos par�metros
	// Mismo nombre de funci�n
	// Java llamar� a la funci�n que 'encaje' con los par�metros
	// Si no encaja ninguna, nos da un error
	// Podemos llamar a funciones entre sobrecargas o no
	static void saludo(String nombre) {
		saludo(nombre,1);
	}
	static void saludo(int n) {
		for (int i = 0; i < n; i++) {
			System.out.println("Hola que tal est�s");
		}
	}
	// Esto s� es una funci�n, porque devolvemos un valor
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
