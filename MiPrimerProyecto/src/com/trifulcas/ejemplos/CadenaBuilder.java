package com.trifulcas.ejemplos;

public class CadenaBuilder {
	public static void main(String[] args) {

		// Creo una cadena con el constructor
		StringBuilder sb = new StringBuilder("Hola ");
		// Añado con append (nunca con el operador +)
		sb.append("que tal");
		System.out.println(sb);
		// Inserto 'Java' en la posición 1
		sb.insert(1, "Java");
		System.out.println(sb);
		// Reemplazo entre la posición 4 y 6 con '###'
		sb.replace(4, 6, "###");
		System.out.println(sb);
		// Elimino lo que hay entre 1 y 3
		sb.delete(1, 3);
		System.out.println(sb);
		// Invierto la cadena
		sb.reverse();
		System.out.println(sb);

		String nombre = "Eva Pi";

		StringBuilder temp = new StringBuilder(nombre);
		nombre = temp.reverse().toString();
		System.out.println(nombre);
		
		System.out.println(duplicar("que","hola que tal que"));
		System.out.println(duplicar("a","hola que tal que"));
	}
	public static String duplicar(String aguja, String pajar) {
		StringBuilder temp=new StringBuilder(pajar);
		int pos=pajar.indexOf(aguja);
		while (pos!=-1) {
			temp.insert(pos, aguja);
			pos=temp.indexOf(aguja,pos+1+aguja.length());
		}
		return temp.toString();
	}
}
