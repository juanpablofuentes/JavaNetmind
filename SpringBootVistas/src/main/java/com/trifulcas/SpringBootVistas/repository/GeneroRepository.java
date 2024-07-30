package com.trifulcas.SpringBootVistas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trifulcas.SpringBootVistas.model.Genero;


public interface GeneroRepository extends JpaRepository<Genero, Integer> {
// Dentro del repositorio podemos crear consultas de una manera 'mágica'
	List<Genero> findByNombreContaining(String nombre);
}
