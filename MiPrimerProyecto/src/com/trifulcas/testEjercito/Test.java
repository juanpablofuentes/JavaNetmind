package com.trifulcas.testEjercito;

import java.util.Scanner;

import com.trifulcas.ejercitos.Ejercito;

public class Test {
	static Scanner in;

	public static void main(String[] args) {
		try {
			in = new Scanner(System.in);
			System.out.println("Bienvenido al simulador. Vamos a crear un ejército");
			System.out.println("¿Cuantos soldados quieres? (máximo 100)");
			int soldados = getNumero(100);
			System.out.println("¿Cuantos lanceros quieres?  (máximo 100)");
			int lanceros = getNumero(100);
			System.out.println("¿Cuantos capitanes quieres? (máximo 100)");
			int capitanes = getNumero(100);
			Ejercito miEjercito = new Ejercito(soldados, lanceros, capitanes);
			System.out.println("Ejercito creado con " + soldados + " soldados " + lanceros + " lanceros y " + capitanes
					+ " capitanes");
			System.out.println("El daño total es " + miEjercito.totalDanyo());
			int respuesta;
			do {
				respuesta = menu("¿Qué quieres hacer?\r\n" + "1- Atacar\r\n" + "2.- Retirada\r\n" + "0.- Salir");
				if (respuesta == 1) {
					atacar(miEjercito);
				} else if (respuesta == 2) {
					retroceder(miEjercito);
				} else if (respuesta != 0) {
					System.out.println("Los valores válidos son 1,2 y 0");
				}
			} while (respuesta != 0);
		} catch (Exception ex) {
			System.out.println("Error");
		}
	}

	public static int menu(String texto) {
		System.out.println(texto);
		int respuesta = getNumero(2);
		return respuesta;
	}

	public static void atacar(Ejercito miEjercito) {
		int respuesta;
		do {
			respuesta = menu(
					"Has decido atacar\r\n" + "1- Con todas las unidades\r\n" + "2.- Con una unidad\r\n" + "0.- Salir");

			if (respuesta == 1) {
				miEjercito.aLaCarga();
			} else if (respuesta == 2) {
				System.out.println("¿Con qué unidad quieres atacar (1-" + miEjercito.getTotalUnidades() + ") ?");
				int unidad = getNumero(miEjercito.getTotalUnidades());
				if (unidad >= 1 && unidad <= miEjercito.getTotalUnidades()) {
					miEjercito.getUnidad(unidad - 1).cargar();
				} else {
					System.out.println("Unidad fuera de rango");
				}
				// Otra manera: miEjercito.cargarUnidad(unidad);)
			} else if (respuesta != 0) {
				System.out.println("Los valores válidos son 1,2 y 0");
			}
		} while (respuesta != 0);
	}

	public static void retroceder(Ejercito miEjercito) {
		int respuesta;
		do {
			respuesta = menu("Has decido retroceder\r\n" + "1- Con todas las unidades\r\n" + "2.- Con una unidad\r\n"
					+ "0.- Salir");

			if (respuesta == 1) {
				miEjercito.retirada();
				
			} else if (respuesta == 2) {
				System.out.println("¿Con qué unidad quieres retroceder (1-" + miEjercito.getTotalUnidades() + ") ?");
				int unidad = getNumero(miEjercito.getTotalUnidades());
				if (unidad >= 1 && unidad <= miEjercito.getTotalUnidades()) {
					miEjercito.getUnidad(unidad - 1).retroceder();
				} else {
					System.out.println("Unidad fuera de rango");
				}
			} else if (respuesta != 0) {
				System.out.println("Los valores válidos son 1,2 y 0");
			}
		} while (respuesta != 0);
	}

	public static int getNumero(int max) {
		boolean ok = true;
		int num = 0;
		do {
			try {
				ok = true;
				num = in.nextInt();
				if (num<0) {
					System.out.println("No valen números negativos");
					ok=false;
				}
				if (num>max) {
					System.out.println("No valen números mayores de "+max);
					ok=false;
				}
			} catch (Exception ex) {
				System.out.println("Debe introducir un número");
				in.nextLine();
				ok = false;
			}
		} while (!ok);
		return num;
	}
}
