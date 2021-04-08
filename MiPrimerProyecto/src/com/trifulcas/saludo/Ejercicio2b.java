package com.trifulcas.saludo;

import java.util.Scanner;

public class Ejercicio2b {

	public static void main(String[] args) {
		double radio;
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println("Introduce el radio");
			radio = in.nextDouble();
			if (radio == 0) {
				break;
			}
			System.out.println("El círculo de radio " + radio + " tiene una circunferencia de " + circunferencia(radio)
					+ " y un área de " + area(radio));
		}
		in.close();
	}

	public static double area(double radio) {
		return Math.PI * radio * radio;
	}

	public static double circunferencia(double radio) {
		return Math.PI * radio * 2;
	}
}
