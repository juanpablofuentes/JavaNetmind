package com.trifulcas.HibernateTemplate04;

import com.trifulcas.models.Actor;
import com.trifulcas.models.Category;
import com.trifulcas.models.City;
import com.trifulcas.models.Country;
import com.trifulcas.models.DAO;
import com.trifulcas.models.Film;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		DAO<City> cityDao = new DAO<City>(City.class);
		System.out.println(cityDao.get(2));
	}
}
