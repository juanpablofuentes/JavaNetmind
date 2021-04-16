package com.trifulcas.preexamen;

public class Ordenador implements Paqueteria{
	private String nombre;
	private int ram;
	private int hdd;
	private String placa;
	
	
	public Ordenador(String nombre, int ram, int hdd, String placa) {
		super();
		this.nombre = nombre;
		this.ram = ram;
		this.hdd = hdd;
		this.placa = placa;
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
	 * @return the ram
	 */
	public int getRam() {
		return ram;
	}
	/**
	 * @param ram the ram to set
	 */
	public void setRam(int ram) {
		this.ram = ram;
	}
	/**
	 * @return the hdd
	 */
	public int getHdd() {
		return hdd;
	}
	/**
	 * @param hdd the hdd to set
	 */
	public void setHdd(int hdd) {
		this.hdd = hdd;
	}
	/**
	 * @return the placa
	 */
	public String getPlaca() {
		return placa;
	}
	/**
	 * @param placa the placa to set
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	@Override
	public String toString() {
		return "Ordenador [nombre=" + nombre + ", ram=" + ram + ", hdd=" + hdd + ", placa=" + placa + "]";
	}
	@Override
	public int getPeso() {
		// TODO Auto-generated method stub
		return 500;
	}
	@Override
	public int getDiagonal() {
		// TODO Auto-generated method stub
		return 70;
	}
	
	
}
