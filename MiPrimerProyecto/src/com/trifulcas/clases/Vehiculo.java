package com.trifulcas.clases;

public class Vehiculo {

	protected int velocidad;
	protected int direccion;
	protected int velocidadMaxima;
	protected int velocidadMinima;
	protected int giroMax;
	protected int giroMin;
	
	public Vehiculo() {
		velocidadMaxima=200;
		velocidadMinima=0;
		giroMax=360;
		giroMin=0;
	}
	
	// El método acelerar con cualquier valor solo es accesible
	// A la propia clase y sus derivadas. No es accesible al usuario
	protected void cambiar(int cantidad) {
		velocidad+=cantidad;
		if (velocidad>velocidadMaxima) {
			velocidad=velocidadMaxima;
		}
		if(velocidad<velocidadMinima) {
			velocidad=velocidadMinima;
		}
	}
	/**
	 * Acelera el coche 10 unidades
	 * La velocidad máxima es de 200 km/hora
	 */
	public void acelerar() {
		cambiar(10);
	}
	/** 
	 * Frena el coche 10 unidades
	 */
	public void frenar() {
		cambiar(-10);
	}
	protected void girar(int cantidad) {
		direccion+=cantidad;
		if (direccion>giroMax) {
			direccion-=giroMax;
		}
		if (direccion<giroMax) {
			direccion+=giroMax;
		}
	}
	public void izquierda() {
		girar(10);
	}
	public void derecha() {
		girar(-10);
	}
	public String estado() {
		return velocidad+" | "+direccion+" | "+velocidadMaxima;
	}
}

class Coche extends Vehiculo{
	public Coche() {
		velocidadMaxima=150;
	}
}

class Bicicleta extends Vehiculo{
	public void acelerar() {
		cambiar(3);
	}
	public void frenar() {
		cambiar(-3);
	}
}
class Tanque extends Vehiculo{
	public void izquierda() {
		girar(90);
	}
	public void derecha() {
		girar(-90);
	}
}