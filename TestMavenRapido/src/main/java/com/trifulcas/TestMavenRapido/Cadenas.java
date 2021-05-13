package com.trifulcas.TestMavenRapido;

public class Cadenas {
	public boolean esPalindromo(String cadena) {
		cadena = normalizar(cadena);
		StringBuilder foo = new StringBuilder(cadena);
		return cadena.equals(foo.reverse().toString());
	}

	// He creado una función normalizar para otros caracteres
	public String normalizar(String cadena) {
		return cadena.toLowerCase().replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o")
				.replace("ú", "u").replace("ü", "u").replace(" ", "").replace(".", "").replace(",", "");
	}
}
