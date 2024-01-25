package com.trifulcas.models;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private int categoryId;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "last_update", nullable = false)
	private Timestamp lastUpdate;

	// Como ya hemos especificado los datos de la tabla en film
	// Aquí nos basta con especificar la entidad en Film
	@ManyToMany(mappedBy="categories")
	// Anotación para evitar que al recuperar la categoría salgan las películas
	@JsonIgnore
	private Set<Film> films=new HashSet<>();
	
	public Category() {
		super();
		Date now = new Date();
		this.lastUpdate = new Timestamp(now.getTime());

	}

	public Category(String name) {
		super();
		this.name = name;
		Date now = new Date();
		this.lastUpdate = new Timestamp(now.getTime());
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", name=" + name + ", lastUpdate=" + lastUpdate + "]";
	}

}
