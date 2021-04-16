package com.trifulcas.examen;

public class Libro implements Estadisticas{
	private String titulo;
	private String autor;
	private int paginas;
	
	
	public Libro(String titulo, String autor, int paginas) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.paginas = paginas;
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
	 * @return the autor
	 */
	public String getAutor() {
		return autor;
	}
	/**
	 * @param autor the autor to set
	 */
	public void setAutor(String autor) {
		this.autor = autor;
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
		return getPaginas()*2;
	}
	@Override
	public double mediaPalabras() {
		// TODO Auto-generated method stub
		return getPaginas()*100;
	}
	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", paginas=" + paginas + "]";
	}
	
	
}
