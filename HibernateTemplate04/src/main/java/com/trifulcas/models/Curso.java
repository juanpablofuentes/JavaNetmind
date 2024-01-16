package com.trifulcas.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCurso;
	
	private String titulo;
	private int creditos;
	
	@ManyToOne
	@JoinColumn(name="idprofesor")
	private Profesor profesor;
	
	@ManyToMany(mappedBy="cursos")
	private Set<Alumno> alumnos=new HashSet<>();
	
	public Curso() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Curso(String titulo, int creditos) {
		super();
		this.titulo = titulo;
		this.creditos = creditos;
	}
	public Curso(String titulo, int creditos, Profesor profesor) {
		super();
		this.titulo = titulo;
		this.creditos = creditos;
		this.profesor=profesor;
	}
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getCreditos() {
		return creditos;
	}
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	
	public Set<Alumno> getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(Set<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	@Override
	public String toString() {
		return "Curso [idCurso=" + idCurso + ", titulo=" + titulo + ", creditos=" + creditos + ", profesor="+profesor.getNombre()+"]";
	}
	
	
}
