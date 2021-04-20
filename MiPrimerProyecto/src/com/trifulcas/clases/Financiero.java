package com.trifulcas.clases;

public interface Financiero {
	// M�todos que se tienen que implementar en aquellas clases
	// que implementen este interfaz
	// Y con los mismos par�metros de entrada y salida
	double interes();
	double irpf(int importe);
}

interface Bolsa extends Financiero{
	void compra();
}