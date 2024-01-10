package com.trifulcas.HibernateTemplate04;

import com.trifulcas.models.Actor;
import com.trifulcas.models.DAO;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	DAO<Actor> actorDao = new DAO<Actor>(Actor.class);
		System.out.println(actorDao.get(2));
		Actor pep=new Actor("pep","pep");
		actorDao.save(pep);
  }
}
