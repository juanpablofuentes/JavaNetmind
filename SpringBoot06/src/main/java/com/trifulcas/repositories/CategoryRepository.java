package com.trifulcas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trifulcas.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
	List<Category> findByNameContaining(String name);

	List<Category> findCategoryByFilmsFilmId(int id);
}
