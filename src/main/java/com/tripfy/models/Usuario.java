package com.tripfy.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="seq1", initialValue=1, allocationSize=100)
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq1")
	private int id;
	@ManyToOne
	@JoinColumn(name="id_rol", foreignKey = @ForeignKey(name="ROL_ID_FK1"))
	private RolUsuario rol;
	@Column
	private String nombre;
	@Column
	private String apellidos;
	@Column
	private String direccion;
	@Column
	private int telefono;
	@Column
	private String email;
	@Column
	private String username;
	@Column
	private String password;
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public RolUsuario getRol() {
		return rol;
	}
	public void setRol(RolUsuario rol) {
		this.rol = rol;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Usuario() {}
	
	public Usuario(RolUsuario rol, String nombre, String apellidos, String direccion, int telefono, String email, String username, String password) {
		super();
		this.rol = rol;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	
	
}
