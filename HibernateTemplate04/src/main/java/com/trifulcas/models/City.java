package com.trifulcas.models;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "city")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "city_id")
	private Short cityId;

	@Column(name = "city", nullable = false)
	private String city;

	@ManyToOne
	@JoinColumn(name = "country_id", nullable = false)
	private Country country;

	@Column(name = "last_update", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date lastUpdate = new Date();

	// Constructor, getters, and setters

	public City() {
	}

	public City(String city, Country country) {
		this.city = city;
		this.country = country;
	}

	public Short getCityId() {
		return cityId;
	}

	public void setCityId(Short cityId) {
		this.cityId = cityId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public java.util.Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(java.util.Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", city=" + city +  "]";
	}

}
