package com.trifulcas.clases;


abstract public class Repaso {

	private String nombre;
	
	/**
	 * @param nombre the nombre to set
	 */
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void saludo() {
		System.out.println("Hola");
	}

	// M�todo abstracto: contrato de obligaci�n de implementar
	abstract public void despedida();
}

class RepasoExt extends Repaso{
	public void tonteria() {
		setNombre("Juan");
		System.out.println("Probando");
	}
	public void despedida() {
		System.out.println("Adios");
	}
}
class RepasoExt2 extends Repaso{
	public void otraTonteria() {
		System.out.println("Buuu");
	}

	@Override
	public void despedida() {
		System.out.println("Chao");
		
	}
	
}