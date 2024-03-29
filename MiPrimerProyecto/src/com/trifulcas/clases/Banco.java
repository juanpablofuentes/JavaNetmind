package com.trifulcas.clases;

// Al implementar 'Financiero' estoy obligado a definir los m�todos
// inclu�dos en el interfaz: interes e irpf
public class Banco implements Financiero {
	private int saldo;

	public Banco() {
		saldo = 9000;
	}

	@Override
	public double interes() {
		if (saldo < 500) {
			return 0.5;
		} else {
			return 0.3;
		}
	}

	@Override
	public double irpf(int importe) {

		return 0.12;
	}

}
