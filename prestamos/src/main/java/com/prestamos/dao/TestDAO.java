package com.prestamos.dao;

import java.sql.Date;
import java.util.List;

public class TestDAO {

	public static void main(String[] args) {
		
		//Creo un POJO con el constructor a ver si va bien
		Prestamos pepe=new Prestamos(1,"hola","adios",Date.valueOf("2021-01-01"));
		
		// Probamos el objeto DAO. No hace nada, pero si hay error saltará
		PrestamosDAO modelo=new PrestamosDAO();
		
		modelo.addPrestamo(pepe);
		
		modelo.deletePrestamo(4);

		Prestamos modificar=new Prestamos(6,"hola","adios",Date.valueOf("2021-01-01"));
		
		modelo.updatePrestamo(modificar);

	}

}
