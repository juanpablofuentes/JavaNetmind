package com.trifulcas.clases;

public interface Financiero {
	// Métodos que se tienen que implementar en aquellas clases
	// que implementen este interfaz
	// Y con los mismos parámetros de entrada y salida
	double interes();
	double irpf(int importe);
}

interface Bolsa extends Financiero{
	void compra();
}
