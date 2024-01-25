package com.trifulcas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trifulcas.models.City;

import jakarta.transaction.Transactional;

public interface CityRepository extends JpaRepository<City, Integer> {
	// Busco las ciudades de un pais con un id determinado
	// dentro de la propiedad Country busco CountryId
	List<City> findByCountryCountryId(int id);
	
	// Lo mismo pero para eliminar
	// La decoración transactional es para que se ejecute como una transacción
	// Por si hay que hacer rollback
	@Transactional
	void deleteByCountryCountryId(int id);
}
