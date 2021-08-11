package com.javadev.restapi.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	@Column
	private String name,address,designation;
	
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getDesignation() {
		return designation;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
	public User()
    {
    }
  
    // Parameterized constructor
    public User(String address, String designation,
                   String name)
    {
        this.name = name;
        this.address = address;
        this.designation = designation;
    }
}

