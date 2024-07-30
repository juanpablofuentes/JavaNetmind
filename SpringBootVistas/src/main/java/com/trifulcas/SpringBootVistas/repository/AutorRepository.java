package com.trifulcas.SpringBootVistas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trifulcas.SpringBootVistas.model.Autor;
import com.trifulcas.SpringBootVistas.model.Genero;


public interface AutorRepository extends JpaRepository<Autor, Integer> {
	List<Genero> findByLibrosGeneroNombreContaining(String cad);

	List<Autor> findByLibrosTituloContaining(String cad);

}
