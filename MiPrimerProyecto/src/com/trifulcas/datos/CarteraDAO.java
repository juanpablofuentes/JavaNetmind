package com.trifulcas.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CarteraDAO {

	private Connection con;
	private int max_records = 1000;

	public CarteraDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prestamos", "root", "");

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public Cartera getCartera(int id) {
		Cartera res = null;
		MonedaDAO moneda=new MonedaDAO();
		try {
			String sql = "select * from cartera where idcartera=?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				res = new Cartera(rs.getInt("idcartera"), rs.getInt("idusuario"),
						rs.getInt("idmoneda"), rs.getInt("cantidad"), 
						moneda.getMoneda(rs.getInt("idmoneda"))) ;
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}
		return res;
	}

	public List<Cartera> getCarteraUsuario(int id){
		List<Cartera> res = new ArrayList<Cartera>();
		
		try {
			String sql = "select * from cartera where idusuario=?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Cartera temp = getCartera(rs.getInt("idcartera"));
				res.add(temp);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return res;
	}

}
