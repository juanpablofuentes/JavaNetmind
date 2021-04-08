package com.trifulcas.ejercitos;

abstract public class Enemigo {
	private String nombre;
	private int fortaleza;
	private int danyo;

	/**
	 * @param nombre the nombre to set
	 */
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @param fortaleza the fortaleza to set
	 */
	protected void setFortaleza(int fortaleza) {
		if (fortaleza >= 0) {
			this.fortaleza = fortaleza;
		}
	}

	/**
	 * @param danyo the danyo to set
	 */
	protected void setDanyo(int danyo) {
		if (danyo >= 0) {
			this.danyo = danyo;
		}
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the fortaleza
	 */
	public int getFortaleza() {
		return fortaleza;
	}

	/**
	 * @return the danyo
	 */
	public int getDanyo() {
		return danyo;
	}

	public Enemigo() {
		// TODO Auto-generated constructor stub
	}

}
