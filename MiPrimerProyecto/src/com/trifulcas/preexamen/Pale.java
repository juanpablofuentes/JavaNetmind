package com.trifulcas.preexamen;

import java.util.ArrayList;
import java.util.List;

public class Pale {
	private int capacidad;
	private int lado;
	private List<Paqueteria> paquetes;

	public Pale(int capacidad, int lado) {
		super();
		this.capacidad = capacidad;
		this.lado = lado;
		paquetes = new ArrayList<Paqueteria>();
	}

	public Pale() {
		this(2000, 500);
	}

	public void addPaquete(Paqueteria paquete) {
		if (cabePaquete(paquete)) {
			paquetes.add(paquete);
		}
	}

	public void eliminarMasPesados(int peso) {
		// Voy del final al principio para que no se me 'mueva' el arraylist
		for (int i = paquetes.size() - 1; i >= 0; i--) {
			if (paquetes.get(i).getPeso() > peso) {
				paquetes.remove(i);
			}
		}
	}

	public int totalPeso() {
		int res = 0;
		for (Paqueteria paquete : paquetes) {
			res += paquete.getPeso();
		}
		return res;
	}

	public int totalAncho() {
		int res = 0;
		for (Paqueteria paquete : paquetes) {
			res += paquete.getDiagonal();
		}
		return res;
	}

	@Override
	public String toString() {
		return "Pale [capacidad=" + capacidad + ", lado=" + lado + ", paquetes=" + paquetes + "]";
	}
	
	public void fueraTelevisores() {
		for (int i = paquetes.size() - 1; i >= 0; i--) {
			if (paquetes.get(i) instanceof Televisor) {
				paquetes.remove(i);
			}
		}
	}
	public boolean cabePaquete(Paqueteria paquete) {
		return totalPeso() + paquete.getPeso() <= capacidad && totalAncho()+paquete.getDiagonal()<=lado;
	}

}
