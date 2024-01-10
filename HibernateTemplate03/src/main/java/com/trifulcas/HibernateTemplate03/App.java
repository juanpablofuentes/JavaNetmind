package com.trifulcas.HibernateTemplate03;

import com.trifulcas.models.Actor;
import com.trifulcas.models.ActorDAO;
public class App 
{
    public static void main( String[] args )
    {
        ActorDAO dao=new ActorDAO();
        Actor first=dao.getActorById(1);
        System.out.println(first);
        first.setFirstName("PENELOPE");
        dao.saveActor(first);
        Actor second=new Actor();
        second.setFirstName("Ana");
        second.setLastName("Pie");
        dao.saveActor(second);
    }
}
