package com.trifulcas.saludo;

public class Recursividad {
	public static void main(String[] args) {
		System.out.println(factorial(5));
		System.out.println(fibonacci(5));
		System.out.println(fibonacci(8));
	}

	// Una funci�n recursiva es una funci�n que se llama a s� misma
	// Factorial: multiplicaci�n desde el 1 hasta el n�mero
	// Factorial: N! -> N*(N-1)! 1!->1
	// factorial(5)-->5*factorial(4)
	// factorial(4)-->4*factorial(3)
	// factorial(3)-->3*factorial(2)
	// factorial(2)-->2*factorial(1)
	// factorial(1)-->1
	public static int factorial(int num) {
		if (num <= 1) {
			return 1;
		} else {
			return num * factorial(num - 1);
		}
	}
	
	/*
	 * Las reglas para definir una funci�n recursiva son dos
	 * a) Tener un caso base, es decir habr� un momento en el que la funci�n
	 * devuelve un valor fijo.
	 * b) Descomponer el problema en la misma funci�n pero de valores m�s peque�os
	 */
	
	/*
	 * Sucesi�n de fibonacci. Empezamos con 1,1 y cada n�mero es la suma de los dos anteriores
	 * 1,1,2,3,5,8,13,21,34,....
	 * Obtener el elemento N de la sucesi�n de fibonacci
	 * Si N es 1 o 2 --> 1
	 * El elemento N es igual a suma de fib(N-1) + fib(N-2)
	 */
	public static int fibonacci(int posicion) {
		if(posicion<=2) {
			return 1;
		} else {
			return fibonacci(posicion-1)+fibonacci(posicion-2);
		}
	}
}
