package com.trifulcas.datos;

public class Cartera {

	private int idcartera;
	private int idusuario;
	private int idmoneda;
	private int cantidad;
	private Moneda moneda;
	public Cartera(int idcartera, int idusuario, int idmoneda, int cantidad,  Moneda moneda) {
		super();
		this.idcartera = idcartera;
		this.idusuario = idusuario;
		this.idmoneda = idmoneda;
		this.cantidad=cantidad;
		this.moneda = moneda;
	}
	
	/**
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the idcartera
	 */
	public int getIdcartera() {
		return idcartera;
	}
	/**
	 * @param idcartera the idcartera to set
	 */
	public void setIdcartera(int idcartera) {
		this.idcartera = idcartera;
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
	 * @return the idmoneda
	 */
	public int getIdmoneda() {
		return idmoneda;
	}
	/**
	 * @param idmoneda the idmoneda to set
	 */
	public void setIdmoneda(int idmoneda) {
		this.idmoneda = idmoneda;
	}
	/**
	 * @return the moneda
	 */
	public Moneda getMoneda() {
		return moneda;
	}
	/**
	 * @param moneda the moneda to set
	 */
	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}
	@Override
	public String toString() {
		return "Cartera [idcartera=" + idcartera + ", idusuario=" + idusuario + ", idmoneda=" + idmoneda + ", cantidad="
				+ cantidad + ", moneda=" + moneda + "]";
	}
	
	
	
}
