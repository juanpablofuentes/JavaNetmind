package com.trifulcas.hibernate;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.trifulcas.models.Actor;
import com.trifulcas.models.City;
import com.trifulcas.models.Country;

public class HibernateUtil {
	  private static  SessionFactory sessionFactory;
	     public static SessionFactory getSessionFactory() {
	    	if (sessionFactory == null) {
				try {
					Configuration configuration = new Configuration();

					// Hibernate settings equivalent to hibernate.cfg.xml's properties
					Properties settings = new Properties();
					settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
					settings.put(Environment.URL, "jdbc:mysql://localhost:3306/sakila");
					settings.put(Environment.USER, "root");
					settings.put(Environment.PASS, "root");
					settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");

					settings.put(Environment.SHOW_SQL, "true");

					settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");


					configuration.setProperties(settings);
					
					configuration.addAnnotatedClass(Actor.class);
					configuration.addAnnotatedClass(City.class);
					configuration.addAnnotatedClass(Country.class);

					ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
							.applySettings(configuration.getProperties()).build();
					
					sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return sessionFactory;
	    }
	 
	    public static void shutdown() {
	        // Close caches and connection pools
	        getSessionFactory().close();
	    }
}
