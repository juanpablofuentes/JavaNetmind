package com.trifulcas.clases;


// Clase abstracta. Es una clase que puede tener de todo como un clase normal
// Pero no puede ser instanciada
// Con frecuencia las clases abstractas incorporan métodos abstractos
abstract public class Animal {
	String nombre;
	// Esto es un método abstracto
	// Significa que sólo definimos parámetros de entrada y salida
	// No especificamos funcionalidad en código
	// Obligar a todas las clases derivadas a implementar este método
	abstract void sonido();
	// Esto es un método normal y corriente
	public void saludo() {
		System.out.println("Me llamo "+nombre);
	}
	
}

class Perro extends Animal{
	public void sonido() {
		System.out.println("Guau");
	}
	public void aullido() {
		System.out.println("Auuuuuu");
	}

}
class Gato extends Animal{
	public void sonido() {
		System.out.println("Miau");
	}
	public void ronroneo() {
		System.out.println("Rrrrrr");
	}
}
class Pato extends Animal{
	public void sonido() {
		System.out.println("CuaCua");
	}
}
class Ornitorrinco extends Animal{

	public void sonido() {
		System.out.println("Bidiji");
	}
}

class Caballo extends Animal{

	@Override
	public void sonido() {
		System.out.println("Brrr");
		
	}
	
}