package com.trifulcas.clases;

public class Alumno {

	public String nombre;
	// Estoy 'ocultando' o negando el acceso al valor de nota desde fuera de la clase
	private double nota;  
	public String curso;
	public int actitud;

	public Alumno(String nombre) {
		this.nombre = nombre;
		actitud = 5;
	}

	public void puntuar(double nota) {
		if (nota >= 0 && nota <= 10) {
			this.nota = nota;
		}
	}

	public void castigo() {
		actitud--;
	}

	public void recompensa() {
		actitud++;
	}

	public boolean aprobado() {
		return nota >= 5 && actitud >= 5;
	}
}


