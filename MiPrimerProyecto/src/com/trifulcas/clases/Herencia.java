package com.trifulcas.clases;

//Herencia
class Producto {
	public String nombre;
	public double precio;
	
	public double PVP() {
		return precio;
	}
	Producto(){
		precio=20;
	}
}

class Intangible extends Producto {
	public String url;
}

class Tangible extends Producto {
	public int stock;
	 
	public double PVP(double iva) {
		return precio*(1+iva);
	}
	Tangible(){
		precio=100;
	}
	
}

class Reposteria extends Tangible {
	public String caracteristicas;
	// Sobreescribe PVP de producto
	public double PVP() {
		return PVP(.21);
	}
}

//Agregación
class Almacen {
	public Reposteria pasteles;
	public Reposteria magdalenas;
	public Intangible cupon;

}