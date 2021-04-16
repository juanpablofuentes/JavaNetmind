package com.trifulcas.examen;

public class Comic implements Estadisticas {

	private String titulo;
	private String coleccion;
	private int paginas;
	
	
	public Comic(String titulo, String coleccion, int paginas) {
		super();
		this.titulo = titulo;
		this.coleccion = coleccion;
		this.paginas = paginas;
	}

	@Override
	public double tiempoLectura() {
		// TODO Auto-generated method stub
		return getPaginas()*.5;
	}

	@Override
	public double mediaPalabras() {
		// TODO Auto-generated method stub
		return getPaginas()*25;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the coleccion
	 */
	public String getColeccion() {
		return coleccion;
	}

	/**
	 * @param coleccion the coleccion to set
	 */
	public void setColeccion(String coleccion) {
		this.coleccion = coleccion;
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
	public String toString() {
		return "Comic [titulo=" + titulo + ", coleccion=" + coleccion + ", paginas=" + paginas + "]";
	}

	
}
