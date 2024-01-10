package com.trifulcas.models;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.trifulcas.hibernate.HibernateUtil;

public class DAO<T> {
	private Class<T> entityClass;
	private Session session;

	public DAO(Class<T> clase) {
		this.entityClass = clase;
		session = HibernateUtil.getSessionFactory().openSession();
	}

	public void save(T Objeto) {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.persist(Objeto);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public List<T> getAll() {
		return session.createQuery("from " + entityClass.getSimpleName(), entityClass).list();

	}

	public T get(int id) {
		return session.get(entityClass, id);
	}

	public boolean delete(int id) {
		try {
			T objeto = session.get(entityClass, id);
			session.remove(objeto);
			return true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}
}
