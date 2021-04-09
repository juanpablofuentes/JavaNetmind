package com.trifulcas.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Acceso {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "");

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from actor");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			}
			rs = stmt.executeQuery("select * from actor");
			while (rs.next()) {
				System.out.println(
						rs.getInt("actor_id") + "  " + rs.getString("first_name") + "  " + rs.getString("last_name"));
			}

			int result=stmt.executeUpdate("insert into actor (first_name, last_name) values ('Eva','Pi')");  
			System.out.println(result+" filas afectadas");

			PreparedStatement ps = con.prepareStatement("select * from actor where first_name like ?");
			ps.setString(1, "%ar%");
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(
						rs.getInt("actor_id") + "  " + rs.getString("first_name") + "  " + rs.getString("last_name"));
			}
			con.close();

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
