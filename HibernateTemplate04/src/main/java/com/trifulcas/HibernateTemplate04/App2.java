package com.trifulcas.HibernateTemplate04;

import com.trifulcas.models.Actor;
import com.trifulcas.models.City;
import com.trifulcas.models.Country;
import com.trifulcas.models.DAO;

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
		Country spain=countryDao.get(87);
		System.out.println(spain);
		City alba=new City("Albacete",spain);
		//cityDao.save(alba);
  }
}
