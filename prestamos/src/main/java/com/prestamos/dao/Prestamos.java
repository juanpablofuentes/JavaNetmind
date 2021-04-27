package com.prestamos.dao;

import java.sql.Date;

// el pojo PRESTAMOS sólo nos sirve para almacenar valores de la base de datos
// Es como un 'pack' donde yo meto toda la información de un registro
public class Prestamos {
	// Lo importante son las propiedades, porque en un POJO el resto de cosas
	// Se generan automáticamente
	private int idprestamos;
	private String nombre;
	private String titulo;
	private Date fecha;
	
	
	@Override
	public String toString() {
		return "Prestamos [idprestamos=" + idprestamos + ", nombre=" + nombre + ", titulo=" + titulo + ", fecha="
				+ fecha + "]";
	}
	
	public Prestamos(int idprestamos, String nombre, String titulo, Date fecha) {
		super();
		this.idprestamos = idprestamos;
		this.nombre = nombre;
		
		this.titulo = titulo;
		this.fecha = fecha;
	}
	/**
	 * @return the idprestamos
	 */
	public int getIdprestamos() {
		return idprestamos;
	}
	/**
	 * @param idprestamos the idprestamos to set
	 */
	public void setIdprestamos(int idprestamos) {
		this.idprestamos = idprestamos;
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
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	
}
