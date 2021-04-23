package com.mantenimiento.dao;

import java.sql.Date;


//Esto es un POJO que representa a los registros de la tabla category
public class Categoria {

	// Los campos los llamamos igual que en la base de datos
	private int category_id;
	private String name;
	private Date last_update;
	
	// Creamos un constructor para crear fácilmente objetos
	public Categoria(int category_id, String name) {
		super();
		this.category_id = category_id;
		this.name = name;
	}
	public Categoria(int category_id, String name, Date last_update) {
		this(category_id,name);
		this.last_update= last_update;
	}
	// Getters y setters que son imprescindibles
	/**
	 * @return the category_id
	 */
	public int getCategory_id() {
		return category_id;
	}
	/**
	 * @param category_id the category_id to set
	 */
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the last_update
	 */
	public Date getLast_update() {
		return last_update;
	}
	/**
	 * @param last_update the last_update to set
	 */
	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}

	@Override
	public String toString() {
		return "Categoria [category_id=" + category_id + ", name=" + name + ", last_update=" + last_update + "]";
	}
	
	
	
}
