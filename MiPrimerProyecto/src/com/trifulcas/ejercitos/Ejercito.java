package com.trifulcas.ejercitos;

public class Ejercito {

	private Infanteria[] infanteria;

	public Ejercito() {
		// Me aprovecho del mismo constructor: palabra clave this
		// La usamos para llamar a los constructores de la clase
		this(10,4,1);
	}

	public Ejercito(int soldados, int lanceros, int capitanes) {
		int total = soldados + lanceros + capitanes;
		infanteria = new Infanteria[total];
		for (int i = 0; i < soldados; i++) {
			infanteria[i] = new Soldado();
		}
		for (int i = soldados; i < soldados+lanceros; i++) {
			infanteria[i] = new Lancero();
		}
		for (int i = soldados+lanceros; i < total; i++) {
			infanteria[i] = new Capitan();
		}
	}

	public int getTotalUnidades() {
		return infanteria.length;
	}
	public int totalDanyo() {
		int total = 0;
		for (Infanteria unidad : infanteria) {
			total += unidad.getDanyo();
		}
		return total;
	}

	public void aLaCarga() {
		for (Infanteria unidad : infanteria) {
			// Si tiene daño ataca, si no no
			if (unidad.getDanyo() > 0) {
				unidad.cargar();
				// Compruebo si unidad es una instancia de Lancero
				if (unidad instanceof Lancero) {
					// Conversión implícita 'al vuelo'
					((Lancero) unidad).ataqueLanza();
					// Implícita sin hacerlo al vuelo
					// Lancero temp=(Lancero) unidad;
					// temp.ataqueLanza();
				}
			}
		}
		System.out.println("Total daño: " + totalDanyo());
	}

	public void retirada() {
		for (Infanteria unidad : infanteria) {
			unidad.retroceder();
		}
	}
	public Infanteria getUnidad(int i) {
		return infanteria[i];
	}
	public void cargarUnidad(int i) {
		infanteria[i].cargar();
	}
}
