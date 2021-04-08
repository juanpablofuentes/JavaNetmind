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
	// Como password s�lo tiene un setter y no tiene getter
	// Es una propiedad de solo escritura. Podemos poner un valor
	// Pero no recuperarlo
	public void setPassword(String password) {
		this.password=password;
	}
	
	// Como dietas s�lo tiene getter podemos obtener el valor
	// Pero no podemos modificarlo. Es una propiedad de s�lo lectura
	public double getDietas() {
		return dietas;
	}
	/**
	 * @return la direcci�n del profesor
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * Esta funci�n es un setter
	 * @param direccion Es la direcci�n del profesor (calle y n�mero)
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