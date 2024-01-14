package com.trifulcas.HibernateTemplate04;

import com.trifulcas.models.*;

/**
 * Hello world!
 *
 */
public class App2 
{
    public static void main( String[] args )
    {
    	DAO<City> cityDao = new DAO<City>(City.class);
    	DAO<Country> countryDao= new DAO<Country>(Country.class);
		System.out.println(cityDao.get(2));
		System.out.println(cityDao.get(2).getCountry());
		Country spain=countryDao.get(87);
		System.out.println(spain);
		City alba=new City("Albacete",spain);
		//cityDao.save(alba);
		DAO<Film> filmDao = new DAO<Film>(Film.class);
		System.out.println(filmDao.get(2));
		DAO<Category> catDao = new DAO<Category>(Category.class);
		System.out.println(catDao.get(2));
		
  }
}
