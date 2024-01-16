package com.trifulcas.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Alumno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idalumno")
	private int idAlumno;
	
	private String nombre;

	@ManyToMany(cascade= {CascadeType.MERGE})
	@JoinTable(
			name="alumno_curso",
			joinColumns= {@JoinColumn(name="idalumno")},
			inverseJoinColumns= {@JoinColumn(name="idcurso")}
			)
	private Set<Curso> cursos=new HashSet<>();
	
	@Column(name="mail")
	private String email;

	public Alumno(String nombre, String email) {
		super();
		this.nombre = nombre;
		this.email = email;
	}

	public Alumno() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(Set<Curso> cursos) {
		this.cursos = cursos;
	}

	@Override
	public String toString() {
		return "Alumno [idAlumno=" + idAlumno + ", nombre=" + nombre + ", email=" + email + "]";
	}
	
	
	
}
