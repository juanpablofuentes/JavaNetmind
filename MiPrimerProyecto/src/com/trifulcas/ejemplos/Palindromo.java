package com.trifulcas.ejemplos;

public class Palindromo {
	private String cadena;
	
	public Palindromo(String cadena) {
		this.cadena=cadena;
	}
	
	public boolean esPalindromo() {
		String cad = normalizar(cadena);
		StringBuilder foo = new StringBuilder(cad);
		return cad.equals(foo.reverse().toString());
	}
	private String normalizar(String cadena) {
		return cadena.toLowerCase().replace("�", "a").replace("�", "e").replace("�", "i").replace("�", "o")
				.replace("�", "u").replace("�","u").replace(" ", "").replace(".", "").replace(",", "");
	}
}
