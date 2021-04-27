package com.prestamos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PrestamosDAO {

	// En esta variable almacenamos la conexión a la base de datos
	private Connection con;

	public PrestamosDAO() {
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

	/**
	 * Paso al método el id del préstamo que quiero obtener Me devuelve un POJO que
	 * almacena los datos del registro de la base de datos
	 * 
	 * @param id del registro de la base de datos
	 * @return Prestamos (pojo con los datos)
	 */
	public Prestamos getPrestamo(int id) {
		try {

			// Ir a la base de datos, recuperar el registro que tenga el id
			// Meterlo dentro de un POJO y devolverlo

			// Me creo la sentencia sql que recupera un préstamo con un id
			// Y le pongo un parámetro que será el id. Se representa con un ?
			String sql = "select * from prestamos where idprestamos=?";

			// Una vez tengo el sql me creo la sentencia preparada
			PreparedStatement stmt = con.prepareStatement(sql);

			// Poniendo en el primer parámetro el valor que me están pasando del id
			stmt.setInt(1, id);

			// Recuperamos los resultados dentro de un ResultSet
			ResultSet rs = stmt.executeQuery();

			// El resultset NO COGE todos los registros del select y los tiene como en un
			// array
			// El resultset es como si fuera un puntero, una flecha que nos apunta al primer
			// Registro del select. Para recuperar hay que usar next
			if (rs.next()) {
				// Si hemos podido obtener un registro en rs tenemos todos los datos
				// del registro de la base de datos. ¿Cómo? con rs.get del tipo y nombre
				// de la columna. Ej. rs.getInt(1) o rs.getInt("idprestamos")

				// ¿Qué hago con estos datos? Empaquetarlos dentro de un POJO para poder
				// devolverlos
				Prestamos resultado = new Prestamos(rs.getInt("idprestamos"), rs.getString("nombre"),
						rs.getString("titulo"), rs.getDate("fecha"));

				return resultado;

			} else {
				return null;
			}

		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}
	}

	public List<Prestamos> getPrestamos() {
		try {

			String sql = "select * from prestamos";

			PreparedStatement stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			// Para almacenar todos los registros tengo que crear un arraylist
			List<Prestamos> resultado = new ArrayList<Prestamos>();

			// En esta ocasión no tengo un if porque son varios registros.
			// Tengo que hacer un bucle hasta que no haya registros o lo que es lo mismo
			// MIENTRAS tengamos registros vamos recorriendo
			while (rs.next()) {
				Prestamos elemento = new Prestamos(rs.getInt("idprestamos"), rs.getString("nombre"),
						rs.getString("titulo"), rs.getDate("fecha"));
				resultado.add(elemento);
			}
			return resultado;

		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}

	}

	public int addPrestamo(Prestamos prestamo) {
		try {

			// Igual que en los métodos anteriores tengo que poner el sql
			// De lo que quiero hacer. En este caso es un insert y... tengo tres parámetros
			String sql="insert into prestamos (nombre,titulo,fecha) values (?,?,?)";
			
			PreparedStatement stmt = con.prepareStatement(sql);

			// Tengo que pasar los parámetros
			stmt.setString(1,prestamo.getNombre() );
			stmt.setString(2, prestamo.getTitulo());
			stmt.setDate(3, prestamo.getFecha());
			
			// Utilizo executeUpdate porque modifico los datos, no obtengo resultados
			// Devuelvo lo que me devuelve el método que son el número de filas afectadas
			return stmt.executeUpdate();
			
		} catch (Exception ex) {
			System.out.println(ex);
			return 0;
		}

	}
	
	public int deletePrestamo(int id) {
		try {

			// Igual que en los métodos anteriores tengo que poner el sql
			// De lo que quiero hacer. En este caso es un delete y... tengo un parámetro
			String sql="delete from prestamos where idprestamos=?";
			
			PreparedStatement stmt = con.prepareStatement(sql);

			// Tengo que pasar los parámetros
			stmt.setInt(1, id);
			
			// Utilizo executeUpdate porque modifico los datos, no obtengo resultados
			// Devuelvo lo que me devuelve el método que son el número de filas afectadas
			return stmt.executeUpdate();
			
		} catch (Exception ex) {
			System.out.println(ex);
			return 0;
		}

	}
	
	public int updatePrestamo(Prestamos prestamo) {
		try {

			// Igual que en los métodos anteriores tengo que poner el sql
			// De lo que quiero hacer. En este caso es un update y... tengo cuatro parámetros
			String sql="update prestamos set nombre=?,titulo=?,fecha=? where idprestamos=?";
			
			PreparedStatement stmt = con.prepareStatement(sql);

			// Tengo que pasar los parámetros
			stmt.setString(1,prestamo.getNombre() );
			stmt.setString(2, prestamo.getTitulo());
			stmt.setDate(3, prestamo.getFecha());
			stmt.setInt(4, prestamo.getIdprestamos());
			
			// Utilizo executeUpdate porque modifico los datos, no obtengo resultados
			// Devuelvo lo que me devuelve el método que son el número de filas afectadas
			return stmt.executeUpdate();
			
		} catch (Exception ex) {
			System.out.println(ex);
			return 0;
		}

	}
	
	
}
