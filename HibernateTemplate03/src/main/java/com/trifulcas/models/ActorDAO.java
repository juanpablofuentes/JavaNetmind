package com.trifulcas.models;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.trifulcas.hibernate.HibernateUtil;


public class ActorDAO {
	private Session session;

	public ActorDAO() {
		// Crea la fábrica de sesiones utilizando la configuración de hibernate.cfg.xml
		this.session = HibernateUtil.getSessionFactory().openSession();
		
	}

	// Método para guardar un nuevo actor
	public void saveActor(Actor actor) {
		  Transaction transaction = session.beginTransaction();
            // save the Alumno object
            session.persist(actor);
            // commit transaction
            transaction.commit();

	}

	// Método para obtener un actor por su ID
	public Actor getActorById(int actorId) {
		return session.get(Actor.class, actorId);

	}

	// Método para obtener todos los actores
	public List<Actor> getAllActors() {
			return session.createQuery("FROM Actor", Actor.class).list();
		
	}

	// Método para actualizar un actor existente
	public void updateActor(Actor actor) {
			session.persist(actor);
			
	}

	// Método para eliminar un actor por su ID
	public void deleteActor(int actorId) {
			Actor actor = session.get(Actor.class, actorId);
			if (actor != null) {
				session.delete(actor);
			}
		
	}

	
}
