package com.trifulcas.ejemplos;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Scanner;

public class TestFechas {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

//		System.out.println("Introduce fecha para saberlo");
//		String f=in.next();
//		LocalDate fecha=LocalDate.parse(f);
//		System.out.println(esDiaPar(fecha));
//		System.out.println(esDiaPar(LocalDate.parse("2020-01-09")));
//		System.out.println(esDiaPar(LocalDate.parse("2020-01-10")));
		System.out.println(siguienteSabado(LocalDate.now()));
		System.out.println(nextSaturday(LocalDate.parse("2021-04-18")));
	}

	// Funci�n que nos diga si un d�a concreto es un fin de semana

	public static boolean finDeSemana(LocalDate fecha) {
		return fecha.getDayOfWeek() == DayOfWeek.SATURDAY || fecha.getDayOfWeek() == DayOfWeek.SUNDAY;
	}

	public static int dia(LocalDate fecha) {
		return fecha.getDayOfMonth();
	}

	public static String esDiaPar(LocalDate fecha) {
		// Obtener el d�a
		int dia = fecha.getDayOfMonth();
		if (dia % 2 == 0) {
			return "Par";
		} else {
			return "Impar";
		}
	}

	public static LocalDate siguienteSabado(LocalDate fecha) {
		// �Es s�bado la fecha que me pasan? S�->Devuelvo
		// No->Puedo probar con ma�ana. Le sumo un d�a y vuelvo a preguntar
		// �Es s�bado? S�->Devuelvo
		// No->Vuelvo a probar con ma�ana
		// As� hasta el s�bado
		while (fecha.getDayOfWeek() != DayOfWeek.SATURDAY) {
			fecha = fecha.plusDays(1);
		}
		return fecha;
	}

	public static LocalDate nextSaturday(LocalDate fecha) {
		int day = fecha.getDayOfWeek().ordinal();
		if (day == 6) {
			fecha = fecha.plusDays(6);
		} else {
			fecha = fecha.plusDays(5 - day);
		}
		return fecha;
	}

}
