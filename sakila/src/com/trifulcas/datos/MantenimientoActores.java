package com.trifulcas.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class MantenimientoActores {
	public static void main(String[] args) {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "");
			System.out.println("Conexión correcta");

			Scanner in = new Scanner(System.in);
			int res = 0;
			do {
				System.out.println(
						"1.- Buscar actores\n2.- Añadir actores\n3.- Modificar actores\n4.- Eliminar\n0.- Salir");
				res = in.nextInt();
				String sql, nombre, apellido;
				int actor_id;
				PreparedStatement ps;
				switch (res) {
				case 1:
					System.out.println("Buscar actores");

					System.out.println("Dime una parte el apellido");
					String cad = in.next();
					sql = "select * from actor where last_name like ?";
					// Creo mi sentencia preparada. Tiene 1 parámetro
					ps = con.prepareStatement(sql);
					ps.setString(1, "%" + cad + "%");
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						String first_name=rs.getString("first_name");
						System.out.println(rs.getString("first_name") + " " + rs.getString("last_name"));
					}

					break;
				case 2:
					System.out.println("Añadir actores");
					System.out.println("Dime el nombre");
					nombre = in.next();
					System.out.println("Dime el apellido");
					apellido = in.next();

					sql = "insert into actor(first_name,last_name) values (?,?)";
					ps = con.prepareStatement(sql);
					ps.setString(1, nombre);
					ps.setString(2, apellido);
					if (ps.executeUpdate() == 1) {
						System.out.println("Registro insertado");
					} else {
						System.out.println("No se ha insertado el registro");
					}

					break;
				case 3:
					System.out.println("Modificar actores");
					System.out.println("Dime el id del actor que quieres modificar");
					actor_id = in.nextInt();
					System.out.println("Dime el nombre");
					nombre = in.next();
					System.out.println("Dime el apellido");
					apellido = in.next();

					sql = "update actor set first_name=?, last_name=? where actor_id=?";
					ps = con.prepareStatement(sql);
					ps.setString(1, nombre);
					ps.setString(2, apellido);
					ps.setInt(3, actor_id);
					if (ps.executeUpdate() == 1) {
						System.out.println("Registro modificado");
					} else {
						System.out.println("No se ha modificado el registro");
					}
					break;
				case 4:
					System.out.println("Eliminar actores");
					System.out.println("Dime el id del actor que quieres eliminar");
					actor_id = in.nextInt();
					sql = "delete from actor where actor_id=?";
					ps = con.prepareStatement(sql);
					ps.setInt(1, actor_id);
					if (ps.executeUpdate() == 1) {
						System.out.println("Registro eliminado");
					} else {
						System.out.println("No se ha eliminado el registro");
					}
					break;
				}
			} while (res != 0);

			con.close();

		} catch (Exception ex) {

			System.out.println(ex);
		}
	}
}