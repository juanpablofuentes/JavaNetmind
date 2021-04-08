package com.trifulcas.HibernatePrueba;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.NativeQuery;

public class Consultas {
	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			String sql = "SELECT first_name, title from actor join film_actor using(actor_id) join film using(film_id) limit 20";
			List<Object[]> lista = session.createNativeQuery(sql).getResultList();
			for(Object[] person : lista) {
			    String nombre = (String) person[0];
			    String titulo = (String) person[1];
			    System.out.println(nombre+","+titulo);
			}
			t.commit();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		factory.close();
		session.close();
	}
}
