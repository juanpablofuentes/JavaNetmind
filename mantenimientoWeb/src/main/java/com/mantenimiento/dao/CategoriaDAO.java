package com.mantenimiento.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

	// Tengo que crear una conexión a la base de datos
	private Connection con;
	private int max_records = 1000;

	public CategoriaDAO() {
		try {
			// Me conecto a la base de datos. Si no da error todo OK
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "");

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	// Tengo que implementar todas las opciones del CRUD

	// Obtener una categoría
	public Categoria getCategoria(int id) {
		try {
			String sql = "select * from category where category_id=?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				Categoria categoria=new Categoria(rs.getInt("category_id"),rs.getString("name"),rs.getDate("last_update"));
				return categoria;
			}else {
				return null;
			}
			
		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}
	}

	// Obtener todas las categorías
	public List<Categoria> getCategorias() {
		try {
			// Consulta sql para obtener todas las categorías
			String sql = "select * from category limit ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			// Con la salvedad de que ponemos un límite de 1000 registros por si acaso
			stmt.setInt(1, max_records);
			
			// Obtenemos el puntero a los resultados
			ResultSet rs = stmt.executeQuery();
			
			// Yo necesito almacenar todos los registros que voy obteniendo
			// ¿Dónde? En un ArrayList del tipo Categoria
			List<Categoria> categorias=new ArrayList<Categoria>();
			
			// MIentras haya registros en la base de datos
			while (rs.next()) {
				// Creame un objeto categoría con los datos de la base de datos
				Categoria categoria=new Categoria(rs.getInt("category_id"),rs.getString("name"),rs.getDate("last_update"));
				// Lo añadimos al arraylist
				categorias.add(categoria);
			}
			// Devolvemos la lista con todas las categorías que hemos creado
			// A partir de los registros de la base de datos
			return categorias;
		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}
	}
	// Crear una categoría
	public int addCategoria(Categoria categoria) {
		return addCategoria(categoria.getName());
	}

	// Crear una categoría
	public int addCategoria(String name) {
		try {
			String sql = "insert into category (name) values (?)";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, name);

			int res = stmt.executeUpdate();
			return res;
		} catch (Exception ex) {
			System.out.println(ex);
			return -1;
		}
	}

	// Eliminar categoría
	public int deleteCategoria(Categoria categoria) {
		return deleteCategoria(categoria.getCategory_id());

	}

	// Eliminar categoría
	public int deleteCategoria(int id) {
		try {
			String sql = "delete from category where category_id=?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, id);

			int res = stmt.executeUpdate();
			return res;

		} catch (Exception ex) {
			System.out.println(ex);
			return -1;
		}
	}

	// Modificar categoría
	public int updateCategoria(Categoria categoria) {
		try {
			String sql = "update category set name=? where category_id=?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, categoria.getName());
			stmt.setInt(2, categoria.getCategory_id());

			int res = stmt.executeUpdate();
			return res;
		} catch (Exception ex) {
			System.out.println(ex);
			return -1;
		}
	}
}
