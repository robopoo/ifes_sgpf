package com.ifes.sgpf.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ifes.sgpf.model.Analista;	



@Repository
public class AnalistaDAO {

	
	
	 @Autowired
	 private SessionFactory sessionFactory;

	
	 
	 
	public void setSessionFactory(SessionFactory sf) {
		  this.sessionFactory = sf;
	}
	 
	 

	public List getAllAnalistas() {
		  Session session = this.sessionFactory.getCurrentSession();
		  List analistaList = session.createQuery("from ANALISTA").list();
		  return analistaList;
	}	
	
	
	
	public Analista getAnalista(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Analista analista = (Analista) session.load(Analista.class, new Integer(id));
		return analista;
	}
	
	

	public Analista addAnalista(Analista analista) {
		
	  Session session = this.sessionFactory.getCurrentSession();
	  session.persist(analista);
	  return analista;
	 }
	
	
	 public void updateAnalista(Analista analista) {
	  Session session = this.sessionFactory.getCurrentSession();
	  session.update(analista);
	 }	



	 public void deleteAnalista(int id) {
		 
	  Session session = this.sessionFactory.getCurrentSession();
	  Analista analista = (Analista) session.load(Analista.class, new Integer(id));
	  
	  if (null != analista) {
	   session.delete(analista);
	  }
	 } 	 	
}//end_class...