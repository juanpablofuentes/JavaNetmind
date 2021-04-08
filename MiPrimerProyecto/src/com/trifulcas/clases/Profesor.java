package com.trifulcas.clases;

public class Profesor {

	private String name;
	private String email;
	private double sueldo;
	private double dietas;
	private String password;
	private String direccion;
	private String seguridad;
	// getters y setters: Poner y obtener valores
	// Getter: obtiene el valor
	public String getNombre() {
		return name;
	}
	//Setter: pone el valor
	public void setNombre(String nombre) {
		this.name=nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String valor) {
		email = valor;
	}
	/**
	 * 
	 * @return
	 */
	public double getSueldo() {
		return sueldo+dietas;
	}
	/**
	 * 
	 * @param sueldo
	 */
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo*.9;
		this.dietas= sueldo*.1;
	}
	// Como password sólo tiene un setter y no tiene getter
	// Es una propiedad de solo escritura. Podemos poner un valor
	// Pero no recuperarlo
	public void setPassword(String password) {
		this.password=password;
	}
	
	// Como dietas sólo tiene getter podemos obtener el valor
	// Pero no podemos modificarlo. Es una propiedad de sólo lectura
	public double getDietas() {
		return dietas;
	}
	/**
	 * @return la dirección del profesor
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * Esta función es un setter
	 * @param direccion Es la dirección del profesor (calle y número)
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
}

class Interino extends Profesor{
	public int antiguedad;
}
class Externo extends Profesor{
	public int contrato;
	public void saludo() {
		System.out.println("Hola que tal");
	}
}

class curso{
	Interino titular;
	Externo ayudante;
}