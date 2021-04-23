package com.mantenimiento.dao;

import java.util.List;

public class TestDao {

	public static void main(String[] args) {
		Categoria drama=new Categoria(1,"Terrorífica");
		System.out.println(drama);
		System.out.println(drama.getName());
		
		CategoriaDAO modelo=new CategoriaDAO();
		
		System.out.println(modelo.getCategorias());
		List<Categoria> categorias=modelo.getCategorias();
		for(Categoria categoria:categorias) {
			System.out.println(categoria.getName());
		}
	}

}
