package com.trifulcas.saludo;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		int[] numeros = new int[5];
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			System.out.println("Introduce el número " + (i + 1));
			numeros[i]=in.nextInt();
		}
		System.out.println("Introduce el número a comprobar");
		int numero=in.nextInt();
		int cont=0;
		for(int i=0;i<numeros.length;i++) {
			if(numeros[i]>=numero) {
				cont++;
			}
		}
		System.out.println("Hay "+cont+" numeros mayores o iguales que "+numero);
		System.out.println("Hay "+mayores(numeros,numero)+" numeros mayores o iguales que "+numero);
		in.close();
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
