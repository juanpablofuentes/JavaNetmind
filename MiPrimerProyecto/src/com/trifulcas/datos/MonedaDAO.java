package com.trifulcas.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MonedaDAO {

	private Connection con;
	private int max_records = 1000;

	public MonedaDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prestamos", "root", "");

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public Moneda getMoneda(int id) {
		Moneda res = null;
		try {
			String sql = "select * from monedas where idmonedas=?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				res = new Moneda(rs.getInt("idmonedas"), rs.getString("nombre"), rs.getDouble("valor"));
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}
		return res;
	}

	

}
