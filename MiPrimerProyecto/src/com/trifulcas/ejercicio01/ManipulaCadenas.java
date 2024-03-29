package com.trifulcas.ejercicio01;

public class ManipulaCadenas {
	private String cadena;

	public ManipulaCadenas(String cadena) {
		this.cadena = cadena;
	}

	public String getCadena() {
		return cadena;
	}

	/**
	 * Busca la cadena dentro de la propiedad de la clase Y si est�, la repite
	 * 
	 * @param cad La cadena a buscar
	 * 
	 */
	public void repetir(String cad) {
		// Averiguar si la cadena que me pasan como par�metro
		// Est� dentro de la cadena de la clase
		// Si no est� no hago nada
		// Si est� inserto la cadena que me pasan en la posici�n
		// de la cadena
		int pos = cadena.indexOf(cad);
		if (pos != -1) {
			// '123456789' y busco '34' est� en la posici�n '2'
			// Yo tengo que insertar '34' en la posici�n 2
			// Manera 1 usando insert de StringBuilder
			StringBuilder temp = new StringBuilder(cadena);
			temp.insert(pos, cad); // '12343456789'
			// cadena = temp.toString();
			// Manera 2 lo mismo pero compacto
			cadena = new StringBuilder(cadena).insert(pos, cad).toString();

			// Manera 3 usando substring
			// cadena = cadena.substring(0, pos) + cad + cadena.substring(pos);
		}

	}

	/**
	 * Elimina el primer car�cter y el �ltimo de la cadena si su longitud es mayor a
	 * 2
	 */
	public void erosionar() {
		// Compruebo si tiene longitud>2
		// Si es as� quito el caracter 1� y �ltimo
		if (cadena.length() >= 2) {
			// No me complico y uso substring
			// cadena = cadena.substring(1, cadena.length() - 1);

			// Me aprovecho de las funcionalidades de StringBuilder
			cadena = new StringBuilder(cadena).deleteCharAt(cadena.length() - 1).deleteCharAt(0).toString();
		}
	}

	/**
	 * Elimina los carcateres centrales Si la longitud de la cadena es par, los dos
	 * del medio Si es impar el car�cter central
	 */
	public void agujero() {
		if (cadena.length() > 0) {
			// Par o impar
			// Si es par quitar los caracteres del medio
			// Si es impar quitar el car�cter del medio
			if (cadena.length() % 2 == 0) {
				// Es par: los dos del medio
				// 'abcdef' 2,3 longitud: 6 6/2-1
				// 'abcd' 1,2 longitud 4 4/2-1
				// 'abcdefgh' 3,4 longitud 8 8/2-1
				int pos = cadena.length() / 2 - 1;
				cadena = new StringBuilder(cadena).delete(pos, pos + 2).toString();

			} else {
				// Es impar: el del medio
				// 'abcde' 2 longitud 5 5/2->2
				// 'abcdefg' 3 longitud es 7/2 ->3
				int pos = (cadena.length() - 1) / 2;
				cadena = new StringBuilder(cadena).deleteCharAt(pos).toString();
			}
		}
	}
}
