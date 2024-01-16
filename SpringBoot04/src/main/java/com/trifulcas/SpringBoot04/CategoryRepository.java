package com.trifulcas.SpringBoot04;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trifulcas.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
