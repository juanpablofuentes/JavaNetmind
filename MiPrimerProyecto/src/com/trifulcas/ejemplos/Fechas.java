package com.trifulcas.ejemplos;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class Fechas {

	public static void main(String[] args) {

		// Para crear una variable que permita guardar una fecha usamos
		// LocalDate
		// fecha Tiene el d�a de hoy LocalDate tiene algunos m�todos est�ticos
		// Y uno de ellos es now() que nos devuelve la fecha de hoy
		LocalDate fecha = LocalDate.now();
		// Otra manera de crear una fecha es utilizar of
		// Usa de par�metros: a�o, mes y d�a
		LocalDate fecha2 = LocalDate.of(2019, 02, 20);
		// Otra manera m�s es utilizar parse que intenta convertir
		// Una cadena en una fecha
		LocalDate fecha3 = LocalDate.parse("2015-08-10");

		System.out.println(fecha);
		// Imprimir en formato ISO (est�ndar, como el mysql)
		System.out.println(fecha.format(DateTimeFormatter.ISO_DATE));
		System.out.println(fecha.format(DateTimeFormatter.ISO_LOCAL_DATE));
		// Formatear con un patr�n definido (dd-MM-yyy)
		System.out.println(fecha.format(DateTimeFormatter.ofPattern("dd-MM-yyy")));
		// Formatear como lo tengamos configurado en el sistema (y tenemos largo, medio
		// o corto)
		System.out.println(fecha.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		System.out.println(fecha.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
		System.out.println(fecha.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));

		System.out.println(fecha2);
		System.out.println(fecha3);

		// A una fecha le puedo a�adir o quitar d�as, meses, semanas y a�os
		LocalDate manyana = LocalDate.now().plusDays(1);
		LocalDate ayer = LocalDate.now().minusDays(1);
		LocalDate semana_que_viene = LocalDate.now().plusWeeks(1);
		System.out.println(manyana);
		System.out.println(ayer);
		System.out.println(semana_que_viene);

		// Puedo a�adir o restar unidades de tiempo
		LocalDate mesAnterior = LocalDate.now().minus(1, ChronoUnit.MONTHS);
		// Podemos a�adir Periodos que es parecido: permite a�adir
		// meses, dias, a�os o combinaciones
		LocalDate finalDate = manyana.plus(Period.ofDays(5));

		System.out.println(finalDate);
		System.out.println(mesAnterior);

		// Puedo obtener de una fecha cualquier valor que me interese
		// El d�a de la semana es una clase que nos permite obtener el nombre
		// Y el n�mero
		DayOfWeek dia = LocalDate.parse("2016-06-12").getDayOfWeek();
		// El d�a del mes es un entero
		int mes = LocalDate.parse("2016-06-12").getDayOfMonth();

		// En el caso de los meses
		int m = LocalDate.parse("2016-06-12").getMonthValue();
		Month mon = LocalDate.parse("2016-06-12").getMonth();

		// Las clases DayOfWeek y Month nos permiten recuperar el nombre
		// Del d�a de la semana y del mes (en ingl�s) pero tambi�n
		// Su n�mero
		System.out.println(dia);
		System.out.println(dia.ordinal());
		System.out.println(mes);
		System.out.println(m);
		System.out.println(mon);
		System.out.println(mon.ordinal());

		// Saber si un a�o es bisiesto
		boolean bisiesto = LocalDate.now().isLeapYear();
		System.out.println(bisiesto);
		boolean antes = LocalDate.parse("2016-06-12").isBefore(LocalDate.parse("2016-06-11"));
		System.out.println(antes);
		boolean despues = LocalDate.parse("2016-06-12").isAfter(LocalDate.parse("2016-06-11"));
		System.out.println(despues);
		// El with nos permite obtener el primer d�a y el �ltimo del mes
		LocalDate primerDiaMes = LocalDate.parse("2016-06-12").with(TemporalAdjusters.firstDayOfMonth());
		System.out.println(primerDiaMes);

		// Formato de fecha Y hora
		LocalDateTime fechaHora = LocalDateTime.parse("2016-06-12T10:00");
		System.out.println(fechaHora);
		System.out.println(fechaHora.format(DateTimeFormatter.ofPattern("dd-MM-yyy HH:mm")));
		System.out.println(fechaHora.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
		System.out.println(fechaHora.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)));
		LocalDateTime inicioDia = LocalDate.parse("2016-06-12").atStartOfDay();
		System.out.println(inicioDia);

		// Tambi�n tenemos la clase s�lo para la hora
		LocalTime ahora = LocalTime.now();
		System.out.println(ahora);
		// Podemos obtenerla de una cadena
		LocalTime seisYMedia = LocalTime.parse("06:30");
		System.out.println(seisYMedia);
		// Podemos indicar hora, minutos y segundos
		LocalTime seisYMedia2 = LocalTime.of(6, 30);
		System.out.println(seisYMedia2);
		LocalTime seisYMedia3 = LocalTime.of(6, 30,15);
		System.out.println(seisYMedia3);
		//Podemos a�adir Cronounidades
		LocalTime sieteYMedia = LocalTime.parse("06:30").plus(1, ChronoUnit.HOURS);
		System.out.println(sieteYMedia);

		// Podemos a�adir duraciones, lo que en Date es Period
		LocalTime siete = seisYMedia.plus(Duration.ofMinutes(30));
		System.out.println(siete);

	}

}
