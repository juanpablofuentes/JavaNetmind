package com.trifulcas.examen;

public class Revista implements Estadisticas {
	private String nombre;
	private int paginas;
	public Revista(String nombre, int paginas) {
		super();
		this.nombre = nombre;
		this.paginas = paginas;
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
	 * @return the paginas
	 */
	public int getPaginas() {
		return paginas;
	}
	/**
	 * @param paginas the paginas to set
	 */
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	@Override
	public double tiempoLectura() {
		// TODO Auto-generated method stub
		return getPaginas()*1.5;
	}
	@Override
	public double mediaPalabras() {
		// TODO Auto-generated method stub
		return getPaginas()*75;
	}
	@Override
	public String toString() {
		return "Revista [nombre=" + nombre + ", paginas=" + paginas + "]";
	}
	
	
}
