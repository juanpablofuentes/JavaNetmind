package com.trifulcas.ejemplos;

public class EjemploStatic {

	public String nombre;
	// Quiere decir dos cosas: Existe aunque no haya instancia de la clase
	// El valor es compartido por todas las instancias de esta clase
	public static String aula; 
	
	public void saludo() {
		System.out.println("Hola "+nombre);
	}
	
	public static void despedida() {
		// Esto da un error no puedo acceder a propiedades no estáticas
		//System.out.println("Adios "+nombre);
	}

	public static void dondeEstoy() {
		System.out.println("Estoy en el aula "+aula);
	}
}
