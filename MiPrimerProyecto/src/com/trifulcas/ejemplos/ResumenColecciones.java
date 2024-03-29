package com.trifulcas.ejemplos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.trifulcas.ejercitos.Infanteria;

public class ResumenColecciones {

	public static void main(String[] args) {
		//Las colecciones nos sirven para almacenar valores de forma din�mica
		// A diferencia de un array el tama�o no est� definido de antemano
		// Hay muchos tipos de colecciones que se engloban en tres tipos:
		// List, Map y Set
		// List->Lista de objetos
		// Set ->Lista de objetos sin duplicados
		// Map-> Lista de pares clave,valor
		
		// Ejemplo de List: ArrayList
		// Lo definimos por el interfaz List
		List<String> productos=new ArrayList<String>();
		
		// A�adimos con add, elminamos con remove
		
		productos.add("Manzana");
		productos.add("Pera");
		productos.add("Melocot�n");
		System.out.println(productos);
		productos.remove("Pera");
		System.out.println(productos);
		
		// Lo recorremos con for each
		for(String el:productos) {
			System.out.println(el);
		}
		
		// Lo cambiamos con set
		productos.set(0, "MAnzana Golden");
		System.out.println(productos);
		
		// Utilidades como contains, indexOf
		// Las utilidades de Collections: sort, shuflle, search...
		
		System.out.println(productos.contains("Melocot�n"));
		
		// Puede ser de cualquier tipo
		List<Integer> foo1=new ArrayList<Integer>();
		List<Boolean> foo2=new ArrayList<Boolean>();
		List<Alumno> foo4=new ArrayList<Alumno>();
		List<Infanteria> foo3=new ArrayList<Infanteria>();
		List<LocalDate> foo5=new ArrayList<LocalDate>();
		
		// Para pares clave, valor tenemos HashMap
		// Que se implementa mediante su interfaz 'Map'
		
		Map<String,String> referencias=new HashMap<String,String>();
		
		// Se a�aden elementos con el put
		referencias.put("QW23", "Tornillo fino 0.2mm");
		referencias.put("QW24", "Tornillo fino 0.4mm");
		referencias.put("QW25", "Tornillo fino 0.8mm");
		
		// Se eliminan con remove
		referencias.remove("QW24");
		
		// Se recorren por valores con foreach
		for(String el:referencias.values()) {
			System.out.println(el);
		}
		
		// Se recorren con clave y valor con EntrySet
		for(Map.Entry<String, String> el:referencias.entrySet()) {
			System.out.println(el.getKey()+" "+el.getValue());
		}
		
		// El tama�o tanto de ArrayList como HashMap est� en size
		System.out.println(referencias.size());
		
		// Pueden ser usados como par�metros en funciones
		// Como propiedades en clases
		// Como valores de retorno en funciones
		
		Alumno pep=new Alumno("Pep",4);
		pep.addNota(8);
		System.out.println(pep.getFromNotas(0));
	}

}
