package com.trifulcas.ejercicio01;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;

public class CitasMedico {
	private LocalDate[] fechas;

	public CitasMedico() {
		// LLamo al constructor con par�metro fecha con la fecha de hoy
		this(LocalDate.now());
	}

	public CitasMedico(String fecha) {
		// Parseo la fecha y llamo al constructor con par�metro fecha
		this(LocalDate.parse(fecha));
	}

	public CitasMedico(LocalDate fecha) {
		// Crear� el array con un tama�o de 12
		// Voy a ir a�adiendo las fechas sumando 15 d�as
		// Hay que comprobar que no sea fin de semana
		this(fecha, 15);
	}

	public CitasMedico(LocalDate fecha, int dias) {
		// Crear� el array con un tama�o de 12
		// Voy a ir a�adiendo las fechas sumando 15 d�as
		// Hay que comprobar que no sea fin de semana
		fechas = new LocalDate[12];
		fechas[0] = siguienteLaborable(fecha);
		for (int i = 1; i < fechas.length; i++) {
			fechas[i] = siguienteLaborable(fechas[i - 1].plusDays(dias));
		}
	}

	/**
	 * Busca el siguiente d�a laborable. Si la fecha es s�bado o domingo pasa al
	 * lunes
	 * 
	 * @param fecha La fecha a comprobar
	 * @return El siguiente d�a laborable a la fecha
	 */
	private LocalDate siguienteLaborable(LocalDate fecha) {

		// Si es s�bado pasamos al lunes sumando dos d�as
		if (fecha.getDayOfWeek() == DayOfWeek.SATURDAY) {
			fecha = fecha.plusDays(2);
		}
		// Si es domingo pasamos al lunes sumando 1 d�a
		if (fecha.getDayOfWeek() == DayOfWeek.SUNDAY) {
			fecha = fecha.plusDays(1);
		}
		return fecha;
	}

	public LocalDate proximaCita() {
		// Devolveremos la pr�xima cita a partir de hoy	
		for(int i=0;i<fechas.length;i++) {
			if (fechas[i].isAfter(LocalDate.now())) {
				return fechas[i];
			}
		}
		return null;
	}

	public LocalDate proximaCitaFeten() {
		// Devolveremos la pr�xima cita a partir de hoy	
		LocalDate res=null;
		for(int i=0;i<fechas.length;i++) {
			if (fechas[i].isAfter(LocalDate.now())) {
				res=fechas[i];
				break;
			}
		}
		return res;
	}
	
	public LocalDate proximaCitaDesordenada() {
		// Devolveremos la pr�xima cita a partir de hoy	
		LocalDate res=null;
		for(int i=0;i<fechas.length;i++) {
			if (fechas[i].isAfter(LocalDate.now())) {
				if (res==null || res.isAfter(fechas[i]))
				res=fechas[i];
			}
		}
		return res;
	}
	public String toString() {
		return Arrays.toString(fechas);
	}
}
