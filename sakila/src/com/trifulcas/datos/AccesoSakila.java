package com.trifulcas.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccesoSakila {

	public static void main(String[] args) {

		try {
			// Lo primero de todo crear una conexi�n CTRL+MAY+O -> importaci�n autom�tica de
			// los paquetes que falten

			// Esta l�nea nos 'registra' el conector mysql dentro de Java
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Aqu� nos creamos la conexi�n con una cadena de conexi�n
			// Lo primero es el tipo de conector: jdbc:mysql
			// Despu�s la url del servidor SGBD //localhost:3306/
			// Despu�s opcionalmente pero est� bien ponerlo la base de datos /sakila
			// Por �ltimo usuario y contrase�a root ''
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "");
			System.out.println("Conexi�n correcta");

			// Statement es una sentencia SQL
			// PreparedStatement es una sentencia SQL lo �nico que 'preparada'

			String sql = "Select * from actor where last_name like '%b%'";
			System.out.println(sql);
			String cad = "b";

			sql = "select * from actor where last_name like '%" + cad + "%'";
			System.out.println(sql);

			// Cuando en mi sentencia tengo par�metros din�micos que me pueden venir
			// de un teclado, o de un fichero o de un bucle o de donde sea
			// Yo puedo crear una sentencia preparada
			// Una sentencia sql en la que dejamos unos huecos para insertar un valor

			// En este insert yo estoy diciendo que voy a insertar un actor, pero no
			// especifico los valores
			// Estoy dejando dos huecos: los interrogantes
			sql = "insert into actor(first_name,last_name) values (?,?)";
			PreparedStatement ps = con.prepareStatement(sql);

			// Yo no puedo ejecutar mi sentencia preparada porque no he rellenado los huecos
			// Pero el conector ya ha establecido un 'plan' para mi sql

			// Para poder ejecutar la sentencia tengo que poner valores en los huecos
			ps.setString(1, "Juan");
			ps.setString(2, "L'hopital");
			// Aqu� ejecuto la sentencia
			ps.executeUpdate();

			// Pongo otros valores en los huecos
			ps.setString(1, "Ana");
			ps.setString(2, "D'anjou");

			// ventajas: M�s claridad que con la concatenaci�n
			// M�s rapidez porque se analiza el plan de ejecuci�n una vez aunque se llame
			// varias
			// Evita inyecci�n SQL
			// Evita problemas con comillas simples

			// Desventajas: Tenmos que indicar los par�metros y cuando son muchos podemos
			// liarnos
			ps.executeUpdate();

			String a="a";
			// Podemos usarlo para modificar o en una condici�n para leer los datos
			ps = con.prepareStatement("select * from actor where first_name like ?");
			ps.setString(1, "%"+a+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(
						rs.getInt("actor_id") + "  " + rs.getString("first_name") + "  " + rs.getString("last_name"));
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
