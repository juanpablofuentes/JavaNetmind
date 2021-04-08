package com.trifulcas.saludo;

import java.util.Scanner;

public class Ejercicio7 {

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
				System.out.println("Introduce la nota " + (j + 1));
				// Guardo la nota en la coordenada adecuada
				notas[i][j] = in.nextInt();

			}
		}
		mostrar(notas);
		int mayor = notas[0][0]; // Esto es una triquiñuela para evitar coger mínimos como el '0'
		int alumno = 0;
		for (int i = 0; i < alumnos; i++) {
			for (int j = 0; j < numero; j++) {
				if (mayor < notas[i][j]) {
					mayor = notas[i][j];
					alumno=i;
				}
			}
		}
		System.out.println("La nota más alta es " + mayor+" y es del alumno "+(alumno+1));
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
}
