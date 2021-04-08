package com.trifulcas.HibernatePrueba;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table(name= "country")   
public class Country {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int country_id;
	
	private String country;
	
	private Date last_update;
	/**
	 * @return the country_id
	 */
	public int getCountry_id() {
		return country_id;
	}

	/**
	 * @param country_id the country_id to set
	 */
	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	public Country() {
		// TODO Auto-generated constructor stub
	}

}
