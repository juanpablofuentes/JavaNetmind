package com.trifulcas.saludo;

import java.util.Scanner;

public class Ejercicios1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// Nombre más largo de 10
		System.out.println("Introduce tu nombre");
		String nombre=in.nextLine();
		
		if (nombre.length()>10) {
			System.out.println("Que nombre más largo");
		}
		
		// Número mayor
		System.out.println("Introduce el número 1");
		int a=in.nextInt();
		System.out.println("Introduce el número 2");
		int b=in.nextInt();
		System.out.println("El número mayor es "+Math.max(a, b));

		// Paridad de dos números
		System.out.println("Introduce el número 1");
		 a = in.nextInt();
		System.out.println("Introduce el número 2");
		 b = in.nextInt();

		if (esPar(a) == esPar(b)) {
			System.out.println("Los dos tienen la misma paridad");
		} else {
			System.out.println("Los dos tienen distinta paridad");
		}

		//Usando operador ternario
		System.out.println("Los dos tienen " + (esPar(a) == esPar(b) ? "la misma" : "distinta") + " paridad");

		in.close();
	}
	// Función que nos devuelve si un número es par
	public static boolean esPar(int num) {
		return num % 2 == 0;
	}

}
