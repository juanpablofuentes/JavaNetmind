package com.trifulcas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trifulcas.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
	// Busco las categorías cuyo nombre contenga una cadena
	List<Category> findByNameContaining(String name);

	// Busco las categorías cuya propiedad 'Films' tengan un id 'FilmId'
	List<Category> findByFilmsFilmId(int id);
}
