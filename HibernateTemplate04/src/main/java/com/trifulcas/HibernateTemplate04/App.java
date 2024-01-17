package com.trifulcas.HibernateTemplate04;

import java.util.List;

import com.trifulcas.models.Actor;
import com.trifulcas.models.DAO;

import jakarta.persistence.Query;


public class App {
	public static void main(String[] args) {
		DAO<Actor> ActorDao = new DAO<Actor>(Actor.class);
		
		ActorDao.getAll()
		Query query = ActorDao.session.createQuery("from Actor where firstName like :param order by firstName", Actor.class);
		query.setParameter("param", "%s%");
		query.setFirstResult(0);
		query.setMaxResults(10);

		List<Actor> pelis=query.getResultList();
		
		for(Actor Actor:pelis) {
			System.out.println(Actor);
		}
		
	
	}
}
