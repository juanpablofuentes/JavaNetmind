package com.trifulcas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trifulcas.models.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {
	// Utilizamos las consultas JPA para buscar los paises cuyo nombre (Country) contenga
	// Una cadena determinada
	List<Country> findByCountryContaining(String country);
}
