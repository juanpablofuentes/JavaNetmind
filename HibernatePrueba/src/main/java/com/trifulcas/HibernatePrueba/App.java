package com.trifulcas.HibernatePrueba;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		Actor e1 = new Actor();

		e1.setFirst_name("Gaurav");
		e1.setLast_name("Chawla");
		Actor e2 = new Actor();

		e2.setFirst_name("Gaurav");
		e2.setLast_name("Chawla");
		session.save(e1);
		session.save(e2);
		t.commit();
		System.out.println("Guardado ok");
		factory.close();
		session.close();
	}
}
