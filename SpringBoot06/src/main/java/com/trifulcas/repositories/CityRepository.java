package com.trifulcas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trifulcas.models.City;

import jakarta.transaction.Transactional;

public interface CityRepository extends JpaRepository<City, Integer> {
	List<City> findByCountryCountryId(int id);
	
	@Transactional
	void deleteByCountryCountryId(int id);
}
