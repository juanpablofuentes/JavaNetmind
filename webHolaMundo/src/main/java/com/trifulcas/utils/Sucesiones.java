package com.trifulcas.utils;

public class Sucesiones {

	public static String fibonacci(int term) {
		int a = 1;
		int b = 1;
		int c;
		String sucesion = "1, 1, ";
		for (int i = 0; i < term; i++) {
			c = a + b;
			a = b;
			b = c;
			sucesion += c + ", ";
		}
		return sucesion;
	}
	
	public static int geometrica(int inicio, int incremento, int terminos) {
		int a=inicio;
		for(int i=0;i<terminos;i++) {
			a*=incremento;
		}
		return a;
	}
}
