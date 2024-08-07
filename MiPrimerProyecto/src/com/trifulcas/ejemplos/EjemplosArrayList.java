package com.trifulcas.ejemplos;

import java.util.ArrayList;
import java.util.List;

public class EjemplosArrayList {

	public static void main(String[] args) {
		// ArrayList de Alumnos, es decir de una clase propia
		List<Alumno> alumnos=new ArrayList<Alumno>();

		// A�adir creandolos al vuelo
		alumnos.add(new Alumno("Eva",6));
		alumnos.add(new Alumno("Rosa",7));
		alumnos.add(new Alumno("Pep",3));
		alumnos.add(new Alumno("Ana",4));
		
		// A�adir creando una variable y a�adiendo esa variable
		Alumno foo=new Alumno("Rosa",8);
		alumnos.add(foo);
		
		// Si he sobreescrito el toString lo puedo ver todo con un
		// simple print
		System.out.println(alumnos);
		List<Alumno> aprobados=aprobados(alumnos);
		System.out.println(aprobados);
	}

	public static List<Alumno> aprobados(List<Alumno> alumnos){
		List<Alumno> res=new ArrayList<Alumno>();
		for(Alumno al:alumnos) {
			if (al.getNota()>=5) {
				res.add(al);
			}
		}
		return res;
	}
	// Tanto lo que devuelvo como el par�metro es de tipo List
	public static List<String> arrayTrim(List<String> lista){
		List<String> res=new ArrayList<String>();
		for(String el:lista) {
			if (el!="") {
				res.add(el);
			}
		}
		return res;
	}
}
