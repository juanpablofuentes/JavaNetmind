package com.trifulcas.ejercicio01;

import java.time.LocalDate;

public class Test {

	public static void main(String[] args) {
		CitasMedico temp = new CitasMedico(LocalDate.now());
		CitasMedico temp2 = new CitasMedico("2021-03-02");
		CitasMedico temp3=new CitasMedico();

		CitasMedico temp4 = new CitasMedico(LocalDate.now(),20);

		System.out.println(temp2);
		System.out.println(temp2.proximaCita());
	}

}
