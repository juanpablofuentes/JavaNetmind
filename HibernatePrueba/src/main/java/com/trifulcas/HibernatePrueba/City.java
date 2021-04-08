package com.trifulcas.HibernatePrueba;



import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity  
@Table(name= "city")   
public class City {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int city_id;
	
	private String city;
	
	private Date last_update;
	
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="country_id")

	private Country country;
	
	

	/**
	 * @return the city_id
	 */
	public int getCity_id() {
		return city_id;
	}



	/**
	 * @param city_id the city_id to set
	 */
	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}



	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}



	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}



	/**
	 * @return the last_update
	 */
	public Date getLast_update() {
		return last_update;
	}



	/**
	 * @param last_update the last_update to set
	 */
	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}



	/**
	 * @return the country
	 */
	public Country getCountry() {
		return country;
	}



	/**
	 * @param country the country to set
	 */
	public void setCountry(Country country) {
		this.country = country;
	}



	public City() {
		// TODO Auto-generated constructor stub
	}

}
