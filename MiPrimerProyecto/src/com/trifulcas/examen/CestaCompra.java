package com.trifulcas.examen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CestaCompra {

	List<Alimento> cesta;
	Map<Alimento, Integer> cestaguay = new HashMap<Alimento, Integer>();

	public CestaCompra() {
		super();
		cesta = new ArrayList<Alimento>();
	}

	public void comprar(Alimento al) {
		cesta.add(al);
	}

	public void comprarguay(Alimento al, int cantidad) {
		cestaguay.put(al, cantidad);
	}

	public double valorNutricional() {
		double res = 0;
		for (Alimento al : cesta) {
			res += al.valorNutricional(1);
		}
		return res;
	}

	public double valorNutricionalguay() {
		double res = 0;
		for (Map.Entry<Alimento, Integer> m : cestaguay.entrySet()) {
			res += m.getKey().valorNutricional(m.getValue());
		}
		return res;
	}

	@Override
	public String toString() {
		return "CestaCompra [cesta=" + cesta + ", cestaguay=" + cestaguay + "]";
	}
	
	
}
