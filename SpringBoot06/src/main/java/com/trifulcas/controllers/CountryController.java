package com.trifulcas.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trifulcas.models.Country;
import com.trifulcas.repositories.CountryRepository;

@RestController
@RequestMapping("/api")
public class CountryController {

	@Autowired
	CountryRepository countryRepository;

	// Encapsulamos todas las respuestas dentro del objeto ResponseEntity
	// Para poder mandar un HTTPSTATUS, que da información del resultado
	// Buscamos un parámetro 'country' en la url para buscar los paises que contengan
	// una cadena. Es parámetro de url /api/country?country=aj
	@GetMapping("/country")
	public ResponseEntity<List<Country>> getAll(@RequestParam(name="country",required = false) String country) {
		List<Country> res = new ArrayList<>();
		if (country == null) {
			// Si no nos han pasado parámetro devuelvo todos
			countryRepository.findAll().forEach(res::add); 
		} else {
			// Si nos han pasado busco los que contengan esa cadena
			countryRepository.findByCountryContaining(country).forEach(res::add);
		}
		if (res.isEmpty()) {
			// Devuelvo status SIN CONTENIDO
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		// Devuelvo la lista
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@GetMapping("/country/{id}")
	public ResponseEntity<Country> getCountry(@PathVariable("id") int id) {
		// Buscamos el pais de ese id y si no null
		Country country = countryRepository.findById(id)
				// .orElseThrow(()->new ResourceNotFoundException("Country not found"));
				.orElse(null);
		
		if (country == null) {
			// Si no lo ha encontrado devolvemos NO ENCONTRADO
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			// Devolvemos el resultado
			return new ResponseEntity<>(country, HttpStatus.OK);
		}
	}

	@PostMapping("/country")
	public ResponseEntity<Country> addCountry(@RequestBody Country country) {
		// Creamos un nuevo Country con los datos que nos pasan y lo guardamos
		Country temp = countryRepository.save(new Country(country.getCountry()));
		// Status CREADO
		return new ResponseEntity<>(temp, HttpStatus.CREATED);
	}
	// En el put tenemos el parámetro del id en la url y los datos del country en el body en formato JSON
	@PutMapping("/country/{id}")
	public ResponseEntity<Country> updateCountry(@PathVariable("id") int id, @RequestBody Country country) {
		// Buscamos el country del id que nos pasan
		Country temp = countryRepository.findById(id).orElse(null);
		if (temp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			// Si existe ponemos los datos que nos han pasado y lo guardamos
			temp.setCountry(country.getCountry());
			return new ResponseEntity<>(countryRepository.save(temp), HttpStatus.OK);

		}
	}
	@DeleteMapping("/country/{id}")
	public ResponseEntity<HttpStatus> deleteCountry(@PathVariable("id") int id) {
		// borramos por id con la función que ya existe
		countryRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
