package com.trifulcas.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Short countryId;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "last_update", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date lastUpdate=new Date();

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<City> cities;

    // Constructor, getters, and setters

    public Country() {
    }

    public Country(String country) {
        this.country = country;
    }

    public Short getCountryId() {
        return countryId;
    }

    public void setCountryId(Short countryId) {
        this.countryId = countryId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public java.util.Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(java.util.Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", country=" + country + ", lastUpdate=" + lastUpdate + ", cities="
				+ cities + "]";
	}
    
}
