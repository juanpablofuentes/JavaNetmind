package com.trifulcas.clases;

public class Productos {
	public String referencia;
	public double precio;
	protected double iva;
	public double descuento;
	
	public double PVP() {
		// La palabra clave this hace referencia al valor
		// de la propiedad del objeto en el que estamos
		return this.precio*(1+this.iva);
	}
	// Función descuento que nos devuelva el precio menos un 10%
	public double descuento() {
		return this.PVP()*(1-this.descuento);
	}
	// Toda clase puede tener un constructor
	// Se llama cuando instanciamos la clase, al hacer new
	// Si pongo un parámetro en elconstructor
	// Obligo a que cuando se instancie pongan ese valor
	public Productos(String referencia) {
		// ¿Qué ponemos dentro de un constructor?
		// Todas aquellas inicializaciones que necesite nuestra clase
		// Si nuestra clase necesita algunos valores por defecto
		// También los ponemos aquí
		this.referencia=referencia;
		this.iva=.21;
		this.descuento=.1;
	}
	
}
