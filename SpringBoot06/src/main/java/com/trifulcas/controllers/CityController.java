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
import org.springframework.web.bind.annotation.RestController;

import com.trifulcas.models.City;
import com.trifulcas.models.Country;
import com.trifulcas.repositories.CityRepository;
import com.trifulcas.repositories.CountryRepository;

@RestController
@RequestMapping("/api")
public class CityController {
	@Autowired
	CountryRepository countryRepository;

	@Autowired
	CityRepository cityRepository;

	@GetMapping("/city")
	public ResponseEntity<List<City>> getAll() {
		List<City> res = new ArrayList<>();
		cityRepository.findAll().forEach(res::add);
		if (res.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	@GetMapping("/city/{id}")
	public ResponseEntity<City> getCity(@PathVariable("id") int id) {
		City city = cityRepository.findById(id)
				// .orElseThrow(()->new ResourceNotFoundException("Country not found"));
				.orElse(null);
		if (city == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(city, HttpStatus.OK);
		}
	}
	
	@GetMapping("/country/{id}/city")
	public ResponseEntity<List<City>> getAllByCountry(@PathVariable("id") int id) {
		List<City> res = new ArrayList<>();
		cityRepository.findByCountryCountryId(id).forEach(res::add);
		if (res.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	@PostMapping("/country/{id}/city")
	public ResponseEntity<City> addCity(@PathVariable("id") int id,@RequestBody City city) {
		Country country=countryRepository.findById(id).orElse(null);
		if (country == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		City temp = new City(city.getCity(),country);
		return new ResponseEntity<>(cityRepository.save(temp), HttpStatus.CREATED);
	}
	@PutMapping("/city/{id}")
	public ResponseEntity<City> updateCity(@PathVariable("id") int id,@RequestBody City city) {
			City temp=cityRepository.findById(id).orElse(null);
		if (temp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		temp.setCity(city.getCity());
		if (city.getCountry()!=null) {
			Country country=countryRepository.findById(city.getCountry().getCountryId()).orElse(null);
			if (country!=null) {
				temp.setCountry(country);
			}
		}
		return new ResponseEntity<>(cityRepository.save(temp), HttpStatus.OK);
	}
	@DeleteMapping("/country/{id}/city")
	public ResponseEntity<HttpStatus> deleteCityCountry(@PathVariable("id") int id) {
		if (!countryRepository.existsById(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			cityRepository.deleteByCountryCountryId(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		}
	@DeleteMapping("/city/{id}")
	public ResponseEntity<HttpStatus> deleteCity(@PathVariable("id") int id) {
		cityRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
