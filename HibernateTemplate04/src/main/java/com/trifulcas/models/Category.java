package com.trifulcas.models;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

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

    @ManyToMany(mappedBy = "categories")
    private Set<Film> employees = new HashSet<>();
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(int categoryId, String name, Timestamp lastUpdate) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.lastUpdate = lastUpdate;
	}

	protected int getCategoryId() {
		return categoryId;
	}

	protected void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected Timestamp getLastUpdate() {
		return lastUpdate;
	}

	protected void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", name=" + name + ", lastUpdate=" + lastUpdate + "]";
	}
    
    
}
