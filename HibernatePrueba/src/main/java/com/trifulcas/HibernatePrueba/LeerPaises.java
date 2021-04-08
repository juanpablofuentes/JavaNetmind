package com.trifulcas.HibernatePrueba;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class LeerPaises {

	public LeerPaises() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			List<Country> lista = session.createQuery("from Country").getResultList();
			for (Country a : lista) {
				System.out.println(a.getCountry());
			}
			
			List<City> lista2 = session.createQuery("from City where city like 'a%'").getResultList();
			for (City a : lista2) {
				System.out.println(a.getCity());
				System.out.println(a.getCountry().getCountry());
			}
			t.commit();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		factory.close();
		session.close();
	}
}
