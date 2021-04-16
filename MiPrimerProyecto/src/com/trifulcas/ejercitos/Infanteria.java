package com.trifulcas.ejercitos;

abstract public class Infanteria extends Enemigo {
	private int armadura;
	
	
	
	/**
	 * @param armadura the armadura to set
	 */
	protected void setArmadura(int armadura) {
		this.armadura = armadura;
	}

	public Infanteria() {
		// TODO Auto-generated constructor stub
	}
	
	abstract public void cargar();
	abstract public void retroceder();

}