package com.trifulcas.HibernateTemplate04;

import com.trifulcas.models.Alumno;
import com.trifulcas.models.Curso;
import com.trifulcas.models.DAO;


public class App {
	public static void main(String[] args) {
		DAO<Curso> cursoDao=new DAO<Curso>(Curso.class);
		DAO<Alumno> alumnoDao=new DAO<Alumno>(Alumno.class);
		
		Curso c=cursoDao.get(1);
		Alumno a=alumnoDao.get(1);
		
		a.getCursos().add(c);
		alumnoDao.save(a);
		
	
	}
}
