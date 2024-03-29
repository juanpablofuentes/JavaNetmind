package com.trifulcas.ejemplos;

public class CadenaBuffer {

	public static void main(String[] args) {
		// Siempre es con constructor
		StringBuffer sb=new StringBuffer("Hola ");
		// A�adir cadenas a una cadena con append
		sb.append("que tal"); 
		// Ni StringBuffer ni StringBuilder tienen el operador +
		//sb+=" Mu bien";
		System.out.println(sb);
		// Inserta 'Java' en la posici�n 1 : HJavaola que tal
		sb.insert(1,"Java");  
		System.out.println(sb);
		// Reemplaza lo que hay entre las posiciones 4 y 6 con '###'
		// El resultado es HJav###la que tal
		sb.replace(4,6,"###");  
		System.out.println(sb);
		// Borra lo que hay entre las posiciones 1 y 3: Hv###la que tal
		sb.delete(1,3);  
		System.out.println(sb);
		// Invertir cadena: lat euq al###vH
		sb.reverse();  
		System.out.println(sb);
		
		String nombre="Eva Pi";
		
		StringBuffer temp=new StringBuffer(nombre);
		nombre=temp.reverse().toString();
		System.out.println(nombre);
		
	}

}
