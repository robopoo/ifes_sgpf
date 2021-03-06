package com.ifes.sgpf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="ANALISTA")
public class Analista {


	 @Id
	 @Column(name="id")
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 int id;

	 @Column(name="nome")
	 String nome;
	 
	 @Column(name="email")
	 String email;
	 
	 @Column(name="telefone")
	 String telefone;
	 
	 
	 
	 public Analista() {
	  super();
	 }
	 
	 
	 
	 public Analista(int i, String nome, String email, String telefone) {
		 
	  super();
	  this.id = i;
	  this.nome = nome;
	  this.email = email;
	  this.telefone = telefone;
	 }

	
	
	 public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
		
}