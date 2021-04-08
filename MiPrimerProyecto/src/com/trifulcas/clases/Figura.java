package com.trifulcas.clases;


// Una clase abstracta no se puede instanciar
// Puede tener propiedades y métodos no abstractos
// Puede tener métodos abstractos
abstract public class Figura {
	private String nombre;
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	// Puede tener métodos abstractos
	// Un contrato para que las clases derivadas implementen el método
	// Los métodos abstractos no incorporan código
	abstract public double area();

}

class Cuadrado extends Figura{
	private int lado;

	public Cuadrado(int lado) {
		super();
		this.lado = lado;
		setNombre("cuadrado");
	}

	@Override
	public double area() {	
		return lado*lado;
	}
	
}
class Circulo extends Figura{
	private int radio;

	public Circulo(int radio) {
		super();
		this.radio = radio;
		setNombre("círculo");

	}

	@Override
	public double area() {
		return Math.PI*radio*radio;
	}
	
}