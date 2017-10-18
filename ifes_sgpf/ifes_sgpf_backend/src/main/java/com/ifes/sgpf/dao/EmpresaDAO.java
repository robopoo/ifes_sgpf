package com.ifes.sgpf.dao;

import java.util.List;

import com.ifes.sgpf.model.Empresa;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class EmpresaDAO {


	 @Autowired
	 private SessionFactory sessionFactory;

	
	
	public void setSessionFactory(SessionFactory sf) {
		  this.sessionFactory = sf;
	}
	
	
	public List getAllEmpresas() {
		
		  Session session = this.sessionFactory.getCurrentSession();
		  List empresaList = session.createQuery("from EMPRESA").list();
		  return empresaList;
	}	
	

	public Empresa getEmpresa(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Empresa empresa = (Empresa) session.load(Empresa.class, new Integer(id));
		return empresa;
	}
	
	
	public Empresa addEmpresa(Empresa empresa) {
	  Session session = this.sessionFactory.getCurrentSession();
	  session.persist(empresa);
	  return empresa;
	 }
	

	 public void updateEmpresa(Empresa empresa) {
	  Session session = this.sessionFactory.getCurrentSession();
	  session.update(empresa);
	 }	


	 public void deleteEmpresa(int id) {
	  Session session = this.sessionFactory.getCurrentSession();
	  Empresa empresa = (Empresa) session.load(Empresa.class, new Integer(id));
	  if (null != empresa) {
	   session.delete(empresa);
	  }
	 } 	 	
}//end_class...