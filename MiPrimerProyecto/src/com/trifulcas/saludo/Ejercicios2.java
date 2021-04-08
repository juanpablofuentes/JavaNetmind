package com.trifulcas.saludo;

import java.util.Scanner;

public class Ejercicios2 {

	public static void main(String[] args) {
		double radio;
		Scanner in = new Scanner(System.in);
		do {
			System.out.println("Introduce el radio");
			radio = in.nextDouble();
			if (radio != 0) {
				System.out.println("El círculo de radio " + radio + " tiene una circunferencia de "
						+ circunferencia(radio) + " y un área de " + area(radio));
			}
		} while (radio != 0);
		in.close();
	}

	public static double area(double radio) {
		return Math.PI * radio * radio;
	}

	public static double circunferencia(double radio) {
		return Math.PI * radio * 2;
	}
}
