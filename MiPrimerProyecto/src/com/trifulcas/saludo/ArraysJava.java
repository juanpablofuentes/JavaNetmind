package com.trifulcas.saludo;

import java.util.Arrays;
import java.util.Collections;

public class ArraysJava {

	public static void main(String[] args) {
		String[] aulas= new String[5];
		// aulas:{...} Espacio vacío de 5 posiciones
		// Mostrar
		mostrar(aulas);
		// Nos rellena un array con el valor que le digamos
		Arrays.fill(aulas, "SIN NOMBRE");
		
		// Mostrar
		mostrar(aulas);
		//Asignar un valor individual a cada aula con el número
		for(int i=1;i<=aulas.length;i++) {
			aulas[i-1]="AULA "+i;
		}
		//Mostrar
		mostrar(aulas);
		// Cambiar el valor por índice
		aulas[2]="AUla Música";
		aulas[4]="AUla auxiliar";
		// Mostrar
		mostrar(aulas);
		
		// Ordenar aulas
		Arrays.sort(aulas);
		mostrar(aulas);
		// Sin importar mayúsculas/minúsculas
		Arrays.sort(aulas, String.CASE_INSENSITIVE_ORDER);
		mostrar(aulas);
		// Orden inverso
		Arrays.sort(aulas, Collections.reverseOrder());
		
		mostrar(aulas);
		
	}
	static void mostrar(String[] tabla) {
		for(String el:tabla) {
			System.out.println(el);
		}
	}

}
