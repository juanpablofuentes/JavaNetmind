package com.trifulcas.saludo;

public class Ejercicio6 {

	public static void main(String[] args) {
		int[][] tabla = new int[3][3];

		// Recorrer todo el array bidimensional
		// Y cuando se cumpla la condición poner un 1
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == j) {
					tabla[i][j] = 1;
				}
			}
		}

		for (int i = 0; i < 3; i++) {
			tabla[i][i] = 1;
		}
		int[][] otra=diagonal(5);
		mostrar(otra);
	}
	public static int[][] diagonal(int tam){
		int[][] tabla=new int[tam][tam];
		for (int i = 0; i < tam; i++) {
			tabla[i][i] = 1;
		}
		return tabla;
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
