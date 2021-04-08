package com.trifulcas.ejemplos;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Scanner;

public class TestFechas {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		
		
		System.out.println("Introduce fecha para saberlo");
		String f=in.next();
		LocalDate fecha=LocalDate.parse(f);
		System.out.println(esDiaPar(fecha));
		System.out.println(esDiaPar(LocalDate.parse("2020-01-09")));
		System.out.println(esDiaPar(LocalDate.parse("2020-01-10")));
	}
	
	// Función que nos diga si un día concreto es un fin de semana
	
	public static boolean finDeSemana(LocalDate fecha) {
		return fecha.getDayOfWeek()==DayOfWeek.SATURDAY ||
				fecha.getDayOfWeek()==DayOfWeek.SUNDAY;
	}
	public static int dia(LocalDate fecha) {
		return fecha.getDayOfMonth();
	}
	
	
	public static String esDiaPar(LocalDate fecha) {
		// Obtener el día
		int dia=fecha.getDayOfMonth();
		if (dia%2==0) {
			return "Par";
		} else {
			return "Impar";
		}
	}

}
