package com.trifulcas.saludo;

public class Referencia {

	public static void main(String[] args) {
		int[] num= {1,2,3,4};
		mostrar(num);
		int[] doble=doble(num);
		mostrar(doble);
		mostrar(num);
		doble[0]=27;
		mostrar(num);
		int[] otroDoble=dobleOk(num);
		mostrar(num);
		mostrar(otroDoble);
		
	}
	static int[] doble(int[] tabla) {
		for(int i=0;i<tabla.length;i++) {
			tabla[i]*=2;
		}
		return tabla;
	}
	static int[] dobleOk(int[] tabla) {
		int[] copia=new int[tabla.length];
		for(int i=0;i<tabla.length;i++) {
			copia[i]=tabla[i]*2;
		}
		return copia;
	}
	static void mostrar(int[] tabla) {
		for(int elemento:tabla) {
			System.out.println(elemento);
		}
	}
}
