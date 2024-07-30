package com.trifulcas.SpringBootVistas.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "libro")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idlibro;

    // Carga ansiosa. El nombre del campo es el mapping en genero
    @ManyToOne
    @JoinColumn(name = "idgenero")
    private Genero genero;

    private String titulo;

    private int paginas;

    // Cuando tenemos many to many tenemos que elegir donde montamos
    // toda la relación con la especificación de la tabla intermedia
    // Y los campos relacionados. Yo lo he hecho aquí pero podría ser
    // en autor, es lo mismo
    @ManyToMany
    @JoinTable(
        name = "libro_autor",
        joinColumns = @JoinColumn(name = "idlibro"),
        inverseJoinColumns = @JoinColumn(name = "idautor")
    )
    // Utilizamos set porque son valores únicos pero podría ser List
    private Set<Autor> autores;

    // Constructor vacío
    public Libro() {
    }

    // Constructor con parámetros
    public Libro(Genero genero, String titulo, int paginas) {
        this.genero = genero;
        this.titulo = titulo;
        this.paginas = paginas;
    }

    // Getters y Setters
    public int getIdlibro() {
        return idlibro;
    }

    public void setIdlibro(int idlibro) {
        this.idlibro = idlibro;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public Set<Autor> getAutores() {
        return autores;
    }

    public void setAutores(Set<Autor> autores) {
        this.autores = autores;
    }

    // Método toString (opcional)
    @Override
    public String toString() {
        return "Libro{" +
                "idlibro=" + idlibro +
                ", genero=" + genero +
                ", titulo='" + titulo + '\'' +
                ", paginas=" + paginas +
                '}';
    }
}