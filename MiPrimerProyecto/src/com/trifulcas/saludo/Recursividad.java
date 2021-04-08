package com.trifulcas.saludo;

public class Recursividad {
	public static void main(String[] args) {
		System.out.println(factorial(5));
		System.out.println(fibonacci(5));
		System.out.println(fibonacci(8));
	}

	// Una función recursiva es una función que se llama a sí misma
	// Factorial: multiplicación desde el 1 hasta el número
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
	 * Las reglas para definir una función recursiva son dos
	 * a) Tener un caso base, es decir habrá un momento en el que la función
	 * devuelve un valor fijo.
	 * b) Descomponer el problema en la misma función pero de valores más pequeños
	 */
	
	/*
	 * Sucesión de fibonacci. Empezamos con 1,1 y cada número es la suma de los dos anteriores
	 * 1,1,2,3,5,8,13,21,34,....
	 * Obtener el elemento N de la sucesión de fibonacci
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
