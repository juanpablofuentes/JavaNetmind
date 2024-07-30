package com.trifulcas.SpringBootVistas.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "autor")
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idautor;

	@Column(nullable = false) // Asegura que la columna no permita valores nulos a nivel de base de datos
	@NotEmpty(message="El nombre del autor no puede estar vacío")
	private String nombre;

	// Como todas las indicaciones de tablas intermedias y foreign keys
	// Las hemos puesto en libro aquí podemos usar solo autores
	@ManyToMany(mappedBy = "autores")
	@JsonIgnore // Para evitar bucles infinitos
	private Set<Libro> libros;

	// Constructor vacío
	public Autor() {
	}

	// Constructor con parámetros
	public Autor(String nombre) {
		this.nombre = nombre;
	}

	// Getters y Setters
	public int getIdautor() {
		return idautor;
	}

	public void setIdautor(int idautor) {
		this.idautor = idautor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Libro> getLibros() {
		return libros;
	}

	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
	}

	// Método toString (opcional)
	@Override
	public String toString() {
		return "Autor{" + "idautor=" + idautor + ", nombre='" + nombre + '\'' + '}';
	}
}