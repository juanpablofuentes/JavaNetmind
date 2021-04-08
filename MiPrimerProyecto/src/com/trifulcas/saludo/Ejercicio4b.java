package com.trifulcas.saludo;

import java.util.Scanner;

public class Ejercicio4b {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int[] numeros=pedirNumeros(5,in);
		int numero=pedirNumero(in);
		System.out.println("Hay "+mayores(numeros,numero)+" mayores que "+numero);
		in.close();
	}
	
	public static int[] pedirNumeros(int tam,Scanner in) {
		int[] numeros=new int[tam];
		for (int i = 0; i < 5; i++) {
			System.out.println("Introduce el número " + (i + 1));
			numeros[i]=in.nextInt();
		}
		return numeros;
	}
	public static int pedirNumero(Scanner in) {
		System.out.println("Introduce el número ");
		int numero=in.nextInt();
		
		return numero;
	}
	public static int mayores(int[] numeros, int numero) {
		int cont=0;
		for(int n:numeros) {
			if (n>=numero) {
				cont++;
			}
		}
		return cont;
	}
}
