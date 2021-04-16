package com.trifulcas.preexamen;

import java.util.ArrayList;
import java.util.List;

public class Almacen {
	private Pale[] pales;
	private List<Paqueteria> paquetes;

	public Almacen() {
		paquetes = new ArrayList<Paqueteria>();
		pales = new Pale[20];
		for (int i = 0; i < 20; i++) {
			pales[i] = new Pale();
		}
	}

	public void addPaquete(Paqueteria paquete) {
		paquetes.add(paquete);
	}

	public void llenarPales() {
		for (int i = paquetes.size() - 1; i >= 0; i--) {
			for (int j = 0; j < 20; j++) {
				if (pales[j].cabePaquete(paquetes.get(i))) {
					pales[j].addPaquete(paquetes.get(i));
					paquetes.remove(i);
					break;
				}
			}
		}
	}
}
