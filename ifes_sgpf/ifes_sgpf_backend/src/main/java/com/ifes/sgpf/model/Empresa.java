package com.ifes.sgpf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="EMPRESA")
public class Empresa {	
	 
	
	 @Id
	 @Column(name="id")
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 int id;



	@Column(name="nomeFantasia")
	 String nomeFantasia;
	 
	 @Column(name="razaoSocial")
	 String razaoSocial;
	 
	 
	 @Column(name="cnpj")
	 String cnpj;
	 
	 
	 
	 public Empresa() {
	  super();
	 }
	 
	 
	 
	 public Empresa(int i, String nomeFantasia, String razaoSocial, String cnpj) {
		 
	  super();
	  this.id = i;
	  this.nomeFantasia = nomeFantasia;
	  this.razaoSocial=razaoSocial;
	  this.cnpj=cnpj;
	  
	 }
	 

	 
	 public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
}//end_class...