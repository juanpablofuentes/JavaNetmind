package com.trifulcas.repaso;

public class Alumno {

	private String nombre;
	private int nota;

	public Alumno(String nombre, String apellido) {
		if (nombre.length() > 5) {
			this.nombre = nombre+" "+apellido;
		} else {
			this.nombre = nombre + " es muy corto";
		}
	}

	public Alumno(String nombre, String apellido, int nota) {
		this(nombre,apellido);
		setNota(nota);
	}

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

	/**
	 * @return the nota
	 */
	public int getNota() {
		return nota;
	}

	/**
	 * @param nota the nota to set
	 */
	public void setNota(int nota) {
		if (nota < 0 || nota > 10) {
			return;
		}
		this.nota = nota;
	}

	public String toString() {
		return nombre + " " + nota;
	}

	public boolean aprobado() {
		return nota >= 5;
	}

	public void trabajoExtra() {
		nota++;
	}
}
