package com.trifulcas.HibernateTemplate01;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.trifulcas.models.Actor;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		try {
			Actor penelope = session.get(Actor.class, 1);
			
			System.out.println(penelope.getFirstName() + " " + penelope.getLastName());
			List<Actor> lista = session.createQuery("from Actor a where a.firstName like '%ar%' ").getResultList();
			for (Actor a : lista) {
				System.out.println(a);
			}
			
			
		} catch (Exception ex) {
			System.out.println(ex);
		}
		session.close();
		factory.close();
    }
}
