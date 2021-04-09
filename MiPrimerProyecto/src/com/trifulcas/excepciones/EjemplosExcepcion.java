package com.trifulcas.excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EjemplosExcepcion {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] foo = new int[3];
		boolean ok = false;
		do {
			try {
				ok = true;
				System.out.println("Introduce numero");
				int num = in.nextInt();
				System.out.println(doble(num));
			} catch (ArithmeticException e) {
				ok = false;
				System.out.println("Error aritmético");
				System.out.println(e.getMessage());
			} catch (ArrayIndexOutOfBoundsException e) {
				ok = false;
				System.out.println("Fuera de índices");
			} catch (InputMismatchException ex) {
				System.out.println("Quillo, mete un número porfi");
				ok = false;
				in.next(); // quitar la cadena de en medio
			} catch (Exception ex) {
				System.out.println(ex);
			}
		} while (!ok);
		System.out.println("Hola que tal");

	}
	/**
	 * Nos devuelve el doble de un número sólo si es positivo
	 * En caso contrario nos da error
	 * @param num el numéro a doblar, positivo
	 * @return el doble
	 */
	static int doble(int num) {
		if (num < 0) {
			throw new ArithmeticException("Doble de negativos no permitido");
		}
		return num * 2;
	}

}
