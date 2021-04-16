package com.trifulcas.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccesoSakila {

	public static void main(String[] args) {

		try {
			// Lo primero de todo crear una conexión CTRL+MAY+O -> importación automática de
			// los paquetes que falten

			// Esta línea nos 'registra' el conector mysql dentro de Java
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Aquí nos creamos la conexión con una cadena de conexión
			// Lo primero es el tipo de conector: jdbc:mysql
			// Después la url del servidor SGBD //localhost:3306/
			// Después opcionalmente pero está bien ponerlo la base de datos /sakila
			// Por último usuario y contraseña root ''
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "");
			System.out.println("Conexión correcta");

			// Statement es una sentencia SQL
			// PreparedStatement es una sentencia SQL lo único que 'preparada'

			String sql = "Select * from actor where last_name like '%b%'";
			System.out.println(sql);
			String cad = "b";

			sql = "select * from actor where last_name like '%" + cad + "%'";
			System.out.println(sql);

			// Cuando en mi sentencia tengo parámetros dinámicos que me pueden venir
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
			// Aquí ejecuto la sentencia
			ps.executeUpdate();

			// Pongo otros valores en los huecos
			ps.setString(1, "Ana");
			ps.setString(2, "D'anjou");

			// ventajas: Más claridad que con la concatenación
			// Más rapidez porque se analiza el plan de ejecución una vez aunque se llame
			// varias
			// Evita inyección SQL
			// Evita problemas con comillas simples

			// Desventajas: Tenmos que indicar los parámetros y cuando son muchos podemos
			// liarnos
			ps.executeUpdate();

			String a="a";
			// Podemos usarlo para modificar o en una condición para leer los datos
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
