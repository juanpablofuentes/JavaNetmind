package com.trifulcas.saludo;

public class Multidimensional {

	public static void main(String[] args) {
		// Un array de 3 números
		int[] numeros = new int[3];

		// Un array de 3x3
		int[][] bidimensional = new int[3][3];

		// Un array de 3x3x3
		int[][][] tridimensional = new int[3][3][3];

		numeros[0] = 5;
		bidimensional[0][0] = 5;
		bidimensional[1][1] = 3;
		tridimensional[0][1][0] = 7;

		for (int i = 0; i < numeros.length; i++) {
			System.out.print(numeros[i]+" | ");
		}
		System.out.println();
		System.out.println();
		for (int i = 0; i < bidimensional.length; i++) {
			for (int j = 0; j < bidimensional[i].length; j++) {
				System.out.print(bidimensional[i][j]+" | ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
		// Array de dos dimensiones
		int[][] irregular= {{1,2,3},{4,5},{6,7,8,9},{10}};
		for (int i = 0; i < irregular.length; i++) {
			for (int j = 0; j < irregular[i].length; j++) {
				System.out.print(irregular[i][j]+" | ");
			}
			System.out.println();
		}
	}

}
