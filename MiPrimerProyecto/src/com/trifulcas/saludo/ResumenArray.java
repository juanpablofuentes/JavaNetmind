package com.trifulcas.saludo;

import java.util.Arrays;

public class ResumenArray {
	public static void main(String[] args) {
		// Definimos array
		// tipo[] nombre={inicializacion}
		// tipo[] nombre=new tipo[tamaño]
		
		String[] alumnos= {"Eva","Ana","Rosa"};
		String[] aulas=new String[5];
		
		// Accedemos por posición
		System.out.println(alumnos[0]);
		aulas[1]="Laboratorio";
		
		// Poner datos en todo el array
		// Puedo usar un bucle o utilizar fill
		
		for(int i=0;i<aulas.length;i++) {
			aulas[i]="Aula "+i;
		}
	
		Arrays.fill(aulas, "Aula");
		
		// Recorrer array for tradicional o el foreach (for (tipo el:array)
		
		for(int i=0;i<alumnos.length;i++) {
			System.out.println(alumnos[i]);
		}
		for(String alumno:alumnos) {
			System.out.println(alumno);
		}
		
		// arrays multidimensionales poniendo varios corchetes
		int[][] datos= {{1,2,3},{4,5,6}};
		
		// Accedo mediante las coordenadas
		datos[0][1]=20;
		
		// Para recorrer o poner valores usaremos un bucle anidado
		for(int i=0;i<datos.length;i++) {
			for (int j=0;j<datos[i].length;j++) {
				datos[i][j]=i+j;
			}
		}
		for(int i=0;i<datos.length;i++) {
			for (int j=0;j<datos[i].length;j++) {
				System.out.print(datos[i][j]+" | ");
			}
			System.out.println();
		}
	}
}
