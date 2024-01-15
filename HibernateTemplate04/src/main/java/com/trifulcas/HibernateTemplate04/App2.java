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
    	// Se muestra la ciudad
		System.out.println(cityDao.get(2));
		// Recuperamos los datos del país
		System.out.println(cityDao.get(2).getCountry());
		Country spain=countryDao.get(87);
		// Se muestra el país con todas sus ciudades
		System.out.println(spain);
		// Al crear una nueva ciudad le decimos de que país es
		// Con la entidad, no con ids ni cosas parecidas
		City alba=new City("Albacete",spain);
		//cityDao.save(alba);
		DAO<Film> filmDao = new DAO<Film>(Film.class);
		System.out.println(filmDao.get(2));
		DAO<Category> catDao = new DAO<Category>(Category.class);
		System.out.println(catDao.get(2));
		Category cat=new Category("Test");
		Film peli=filmDao.get(2);
		//catDao.save(cat);
		// Para añadir relaciones n a n
		// Añado los elementos a las listas respectivas
		// Aquí a las categorías de la película
		// Añado una categoría
		peli.getCategories().add(catDao.get(3));
		filmDao.save(peli);
  }
}
