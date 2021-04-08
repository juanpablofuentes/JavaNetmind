package com.trifulcas.saludo;

import java.util.Scanner;

public class EjemplosFunciones {
	static int numero;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Introduce un número");
		numero = in.nextInt();
		System.out.println(doble(numero));
		System.out.println(numero);
	}

	public static int doble(int n) {
		n*=2;
		return n;
	}
}
