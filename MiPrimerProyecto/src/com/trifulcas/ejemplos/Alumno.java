package com.trifulcas.ejemplos;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
	private String nombre;
	private int nota;
	private List<Integer> notas;
	
	
 	public Alumno(String nombre, int nota) {
		super();
		this.nombre = nombre;
		this.nota = nota;
		notas=new ArrayList<Integer>();
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
		this.nota = nota;
	}
	
	public String toString() {
		return nombre+"|"+nota;
	}
	public void addNota(int nota) {
		notas.add(nota);
	}
	public int getFromNotas(int index) {
		return notas.get(index);
	}
}
