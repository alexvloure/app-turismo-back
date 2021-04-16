package com.tripfy.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="seq4", initialValue=1, allocationSize=100)
public class Alojamiento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq4")
	private int id;
	@Column
	private String nombre;
	@Column
	private String direccion;
	@Column
	private String contacto;
	@Column
	private String tipo;
	@Column
	private String descripcion;
	@Column
	private float valoracion;
	@Column
	private String caracteristicas;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getValoracion() {
		return valoracion;
	}
	public void setValoracion(float valoracion) {
		this.valoracion = valoracion;
	}
	public String getCaracteristicas() {
		return caracteristicas;
	}
	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	
	public Alojamiento() {};
	
	public Alojamiento(String nombre, String direccion, String contacto, String tipo, String descripcion,
			int valoracion, String caracteristicas) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.contacto = contacto;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.valoracion = valoracion;
		this.caracteristicas = caracteristicas;
	}
	
	
}
