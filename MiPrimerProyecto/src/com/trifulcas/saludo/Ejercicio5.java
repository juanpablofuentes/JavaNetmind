package com.trifulcas.saludo;

import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] alumnos = new String[6];
		for (int i = 0; i < 6; i++) {
			System.out.println("Introduce el alumno " + (i + 1));
			alumnos[i] = in.nextLine();
		}
		System.out.println("Introduce el alumno a buscar");
		String alumno = in.nextLine();
		boolean esta = false;
		for (String el : alumnos) {
			// Para comparar dos strings
			if (alumno.equals(el)) {
				esta = true;
			}
		}
		System.out.println("El alumno "+alumno+(esta?"":" no ")+" está en la lista");
		in.close();
	}

}
