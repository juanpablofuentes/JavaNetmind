package com.prestamos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AmigosDAO {
	private Connection con;

	public AmigosDAO() {
		try {
			// Esta línea registra el driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Aquí creamos la conexión con:
			// driver: jdbc:mysql
			// url del servidor: localhost
			// Puerto del servidor: 3306
			// Base de datos: prestamos
			// Usuario: root
			// Contraseña: ""
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prestamos", "root", "");

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	
}
