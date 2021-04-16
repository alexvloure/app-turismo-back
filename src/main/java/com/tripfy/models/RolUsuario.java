package com.tripfy.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="seq2", initialValue=1, allocationSize=100)
public class RolUsuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq2")
	private int id;
	@Column
	private String rol;
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	public RolUsuario() {}
	
	public RolUsuario(String rol) {
		super();
		this.rol = rol;
	}
	
}
