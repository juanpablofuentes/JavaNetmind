package com.trifulcas.repaso;

public class Repaso {

	public static void main(String[] args) {

		Alumno pepe = new Alumno("Pepe pérez", "");

		Alumno eva = new Alumno("Eva", "", 50);
		System.out.println(eva);

		Becado ana = new Becado("Ana", "Ros");

		ana.setNota(3);
		ana.trabajoExtra();
		System.out.println(ana);
		System.out.println(ana.aprobado());

		ana.setImporteBeca(100);
		ana.setDuracion(10);
		System.out.println(ana);

		Componente[] almacen = { new Electronicos("MEMORIA ram"), new Ferreteria("Tornillo"),
				new Ferreteria("Tuerca") };

		Electronicos ram=new Electronicos("Memoria ram");
		System.out.println(ram.numSerie());
		Componente chip=new Electronicos("Chipset");
		almacen[0]=chip;
		almacen[0]=ram;
		
		for (Componente componente : almacen) {
			System.out.println(componente.referencia());
			if (componente instanceof Electronicos) {
				System.out.println(((Electronicos) componente).numSerie());
			}
		}
		

	}

}
