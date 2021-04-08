package com.trifulcas.clases;

abstract public class Broker implements Bolsa {

	public Broker() {
	}
	abstract void comision();
}


// Esta clase hereda:
// 1.- El contrato de el método abstracto comision de su clase madre
// 2.- El contrato del interfaz Bolsa que ha adquirido la madre
// 3.- El contrato del interfaz Financiero que ha adquirido Bolsa por extenderlo
class WallStreet extends Broker{

	@Override
	public void compra() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double interes() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double irpf(int importe) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	void comision() {
		// TODO Auto-generated method stub
		
	}
	
}


