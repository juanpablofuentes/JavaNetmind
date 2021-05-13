package com.trifulcas.TestMavenRapido;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class CadenasTest {

	Cadenas cadenas=new Cadenas();
	@Test
	public void testEsPalindromo() {
		assertEquals(true,cadenas.esPalindromo("Sara Baras"));
		assertEquals(false,cadenas.esPalindromo("Hola"));
	}

	@Test
	public void testNormalizar() {
		assertEquals("aeiou",cadenas.normalizar("ÁéÍÓÚ"));
	}

}
