package com.trifulcas.repaso;

public abstract class Componente {

	private String nombre;

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Componente(String nombre) {
		super();
		this.nombre = nombre;
	}
	public abstract String referencia();
	
}
