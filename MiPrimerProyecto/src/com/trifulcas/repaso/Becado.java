package com.trifulcas.repaso;

public class Becado extends Alumno {

	private int importeBeca;
	private int duracion;
	public Becado(String nombre, String apellido) {
		super(nombre, apellido);
	}
	/**
	 * @return the importeBeca
	 */
	public int getImporteBeca() {
		return importeBeca;
	}
	/**
	 * @param importeBeca the importeBeca to set
	 */
	public void setImporteBeca(int importeBeca) {
		this.importeBeca = importeBeca;
	}
	/**
	 * @return the duracion
	 */
	public int getDuracion() {
		return duracion;
	}
	/**
	 * @param duracion the duracion to set
	 */
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String toString() {
		return super.toString()+" "+importeBeca+" "+duracion;
	}
	
}
