package com.trifulcas.HibernatePrueba;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity  
@Table(name= "actor")   
public class Actor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int actor_id;
	
	private String first_name;
	private String last_name;
	
	public Actor() {
		
	}
	/**
	 * @return the actor_id
	 */
	public int getActor_id() {
		return actor_id;
	}
	/**
	 * @param actor_id the actor_id to set
	 */
	public void setActor_id(int actor_id) {
		this.actor_id = actor_id;
	}
	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}
	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}
	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	@Override
	public String toString() {
	return "Actor [id=" + actor_id + ", nombre=" + first_name+" "+last_name + "]";
	}
}
