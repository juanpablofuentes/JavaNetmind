package com.trifulcas.saludo;

import java.util.Scanner;

public class EjemploMulti {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		// Pido el número de alumnos (alto de mi tabla multidimensional)
		System.out.println("Introduce el número de alumnos");
		int alumnos = in.nextInt();
		// Pido el número de notas (ancho de mi tabla multidimensional)
		System.out.println("Introduce el número de notas por alumno");
		int numero = in.nextInt();
		// Creo un array multidimensional con los datos que me han dado
		int[][] notas = new int[alumnos][numero];

		// Para pedir los datos tengo que usar un bucle anidado
		// El primero (i) es de los alumnos
		// El segundo (j) es de las notas
		// La combinación (i,j) son las coordenadas de mi array bidimensional
		for (int i = 0; i < alumnos; i++) {
			System.out.println("Introduce las notas del alumno " + (i + 1));
			for (int j = 0; j < numero; j++) {
				System.out.println("Introduce las nota " + (j + 1));
				// Guardo la nota en la coordenada adecuada
				notas[i][j] = in.nextInt();

			}
		}
		mostrar(notas);

		// Para cada alumno la nota más alta
		for (int i = 0; i < alumnos; i++) {
			System.out.print("La nota más alta del alumno " + (i + 1) + " es: ");
			System.out.println(mayor(notas[i]));
		}

		// Para cada alumno la media
		for (int i = 0; i < alumnos; i++) {
			System.out.print("La media de notas del alumno " + (i + 1) + " es: ");
			
			System.out.println(media(notas[i]));
		}
	}

	static void mostrar(int[][] tabla) {
		// Es otro bucle anidado porque tengo dos dimensiones
		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla[i].length; j++) {
				System.out.print(tabla[i][j] + " | ");
			}
			System.out.println();
		}
	}
	static int mayor(int[] numeros) {
		int mayor=numeros[0];
		for(int n:numeros) {
			if (n>mayor) {
				mayor=n;
			}
		}
		return mayor;
	}
	static int media(int[] numeros) {
		int suma=0;
		for(int n:numeros) {
			suma+=n;
		}
		return suma/numeros.length;
	}

	/*
	 * notas[2][3] (2x3)
	 * 
	 * |3 | 4 | 5 | 
	 * |2 | 6 | 10 |
	 * 
	 * notas[0]=|3 | 4 | 5 | 
	 * notas[1]=|2 | 6 | 10 |
	 * 
	 * notas[0] es un array normal de una dimensión
	 * notas[1] es otro array de una dimensión
	 * int[] foo=notas[0]
	 */
	
}
