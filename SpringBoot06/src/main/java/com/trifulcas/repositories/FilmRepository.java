package com.trifulcas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trifulcas.models.Film;

public interface FilmRepository extends JpaRepository<Film, Integer> {
	List<Film> findByTitleContainingOrDescriptionContaining(String text1, String text2);

	List<Film> findByCategoriesCategoryId(int id);

}
