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

	@GetMapping("/country")
	public ResponseEntity<List<Country>> getAll(@RequestParam(required = false) String country) {
		List<Country> res = new ArrayList<>();
		if (country == null) {
			countryRepository.findAll().forEach(res::add);
		} else {
			countryRepository.findByCountryContaining(country).forEach(res::add);
		}
		if (res.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@GetMapping("/country/{id}")
	public ResponseEntity<Country> getCountry(@PathVariable("id") int id) {
		Country country = countryRepository.findById(id)
				// .orElseThrow(()->new ResourceNotFoundException("Country not found"));
				.orElse(null);
		if (country == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(country, HttpStatus.OK);
		}
	}

	@PostMapping("/country")
	public ResponseEntity<Country> addCountry(@RequestBody Country country) {
		Country temp = countryRepository.save(new Country(country.getCountry()));
		return new ResponseEntity<>(temp, HttpStatus.CREATED);
	}

	@PutMapping("/country/{id}")
	public ResponseEntity<Country> updateCountry(@PathVariable("id") int id, @RequestBody Country country) {
		Country temp = countryRepository.findById(id).orElse(null);
		if (temp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			temp.setCountry(country.getCountry());
			return new ResponseEntity<>(countryRepository.save(temp), HttpStatus.OK);

		}
	}
	@DeleteMapping("/country/{id}")
	public ResponseEntity<HttpStatus> deleteCountry(@PathVariable("id") int id) {
		countryRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
