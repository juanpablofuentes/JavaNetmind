package com.trifulcas.HibernateTemplate02;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.trifulcas.hibernate.HibernateUtil;
import com.trifulcas.models.Actor;

public class Test2 {

	public static void main(String[] args) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		try {
			Actor penelope = session.get(Actor.class, 1);
			System.out.println(penelope.getFirstName() + " " + penelope.getLastName());
		} catch (Exception ex) {
			System.out.println(ex);
		}
		session.close();
	}

}
