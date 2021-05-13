package com.trifulcas.datos;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

	private int idusuario;
	private String nombre;
	private List<Cartera> cartera;
	public Usuario(int idusuario, String nombre) {
		super();
		this.idusuario = idusuario;
		this.nombre = nombre;
		cartera=new ArrayList<Cartera>();
	}
	
	/**
	 * @return the cartera
	 */
	public List<Cartera> getCartera() {
		return cartera;
	}

	/**
	 * @param cartera the cartera to set
	 */
	public void setCartera(List<Cartera> cartera) {
		this.cartera = cartera;
	}

	/**
	 * @return the idusuario
	 */
	public int getIdusuario() {
		return idusuario;
	}
	/**
	 * @param idusuario the idusuario to set
	 */
	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
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
	@Override
	public String toString() {
		return "Usuario [idusuario=" + idusuario + ", nombre=" + nombre + ", cartera=" + cartera + "]";
	}
	
	
	
}
