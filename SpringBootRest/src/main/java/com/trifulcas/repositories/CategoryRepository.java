package com.trifulcas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trifulcas.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
