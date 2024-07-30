package com.trifulcas.SpringBootVistas.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "genero")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idgenero;

    private String nombre;

    // Carga perezosa, pero al serializar siempre carga
    // Mapeamos por 'genero', que es el campo en la entidad relacionada
    @OneToMany(mappedBy = "genero")
    @JsonIgnore  // Quitar este campo NO de la entidad SI de la srialización
    private Set<Libro> libros;

    // Constructor vacío
    public Genero() {
    }

    // Constructor con parámetros
    public Genero(String nombre) {
        this.nombre = nombre;
    }

    // Getters y Setters
    public int getIdgenero() {
        return idgenero;
    }

    public void setIdgenero(int idgenero) {
        this.idgenero = idgenero;
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
        return "Genero{" +
                "idgenero=" + idgenero +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
