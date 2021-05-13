package com.trifulcas.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

	private Connection con;
	private int max_records = 1000;

	public UsuarioDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prestamos", "root", "");

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public Usuario getUsuario(int id) {
		Usuario res = null;
		CarteraDAO cartera=new CarteraDAO();
		try {
			String sql = "select * from usuario where idusuario=?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				res = new Usuario(rs.getInt("idusuario"),rs.getString("nombre"));
				res.setCartera(cartera.getCarteraUsuario(rs.getInt("idusuario")));
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}
		return res;
	}

	

}
