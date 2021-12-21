package com.example.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="userid")
	private Long id;
	private String email;
	private String password;
	private String firstname;
	private String lastname;

	
	
	public User() {
		super();
	}
	public Long getId() {
		return id;
	}
	
	
	
	public User(Long id, String email, String password, String firstname, String lastname) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
	
	}
	public User setId(Long id) {
		this.id = id;
		return this; 

	}
	public String getEmail() {
		return email;
	}
	public User setEmail(String email) {
		this.email = email;
		return this; 
	}
	public String getPassword() {
		return password;
	}
	public User setPassword(String password) {
		this.password = password;
		return this; 

	}
	public String getFirstname() {
		return firstname;
	}
	public User setFirstname(String firstname) {
		this.firstname = firstname;
		return this; 

	}
	public String getLastname() {
		return lastname;
	}
	public User setLastname(String lastname) {
		this.lastname = lastname;
		return this; 

	}
	
	

}
