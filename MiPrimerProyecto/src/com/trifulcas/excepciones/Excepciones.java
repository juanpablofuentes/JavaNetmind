package com.trifulcas.excepciones;

public class Excepciones {

	public static void main(String[] args) {
		System.out.println(dividir(3,0));
		try {
			int a[] = new int[7];
			
			// a[14] = 30 ;
			a[4] = 30 / 0;
			System.out.println("Sin errores");
		} catch (ArithmeticException e) {
			System.out.println("Error aritmético");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Fuera de índices");
		} catch (Exception e) {
			System.out.println("Otra excepción");
		} finally {
			System.out.println("Bloque final");
		}
		System.out.println("Fuera del try");
	}


	public static int dividir(int dividendo, int divisor) {
		try {
		return dividendo/divisor;
		} catch(Exception ex) {
			return Integer.MAX_VALUE;
		}
	}

}
