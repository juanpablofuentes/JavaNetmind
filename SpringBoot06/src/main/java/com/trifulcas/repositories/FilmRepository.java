package com.trifulcas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trifulcas.models.Film;

public interface FilmRepository extends JpaRepository<Film, Integer> {
	// Busco las películas cuyo Title contenga un texto o cuya Description contenga un texto
	List<Film> findByTitleContainingOrDescriptionContaining(String text1, String text2);

	// Películas de una categoría determinada
	// Propiedad 'Categories' Propiedad CategoryId
	List<Film> findByCategoriesCategoryId(int id);
}
