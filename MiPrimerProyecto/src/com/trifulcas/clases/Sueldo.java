package com.trifulcas.clases;


// Lo mismo que en Banco. Pero 'Sueldo' y 'Banco' son dos clases que
// no están relacionadas por herencia
public class Sueldo implements Financiero {

	public Sueldo() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public double interes() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double irpf(int importe) {
		// TODO Auto-generated method stub
		return 0.15;
	}

}
