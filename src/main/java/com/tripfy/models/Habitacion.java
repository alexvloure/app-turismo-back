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
@SequenceGenerator(name="seq5", initialValue=1, allocationSize=100)
public class Habitacion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq5")
	private int id;
	@ManyToOne
	@JoinColumn(name="id_alojamiento", foreignKey = @ForeignKey(name="ALOJAMIENTO_ID_FK5"))
	private Alojamiento alojamiento;
	@Column
	private String tipo;
	@Column
	private Integer cantidad;
	@Column
	private int n_huespedes;
	@Column
	private float precio_por_noche;
	// Sólo será distinto de 0 si la propiedad booleana "ofertas" es true
	@Column
	private int porcentaje_descuento;
	@Column
	private int camas;
	@Column
	private boolean oferta;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Alojamiento getAlojamiento() {
		return alojamiento;
	}
	public void setAlojamiento(Alojamiento alojamiento) {
		this.alojamiento = alojamiento;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public int getN_huespedes() {
		return n_huespedes;
	}
	public void setN_huespedes(int n_huespedes) {
		this.n_huespedes = n_huespedes;
	}
	public float getPrecio_por_noche() {
		return precio_por_noche;
	}
	public void setPrecio_por_noche(float precio_por_noche) {
		this.precio_por_noche = precio_por_noche;
	}
	public int getPorcentaje_descuento() {
		return porcentaje_descuento;
	}
	public void setPorcentaje_descuento(int porcentaje_descuento) {
		this.porcentaje_descuento = porcentaje_descuento;
	}
	public int getCamas() {
		return camas;
	}
	public void setCamas(int camas) {
		this.camas = camas;
	}
//	public Date getFechas_reserva() {
//		return fechas_reserva;
//	}
//	public void setFechas_reserva(Date fechas_reserva) {
//		this.fechas_reserva = fechas_reserva;
//	}
	public boolean isOferta() {
		return oferta;
	}
	public void setOferta(boolean oferta) {
		this.oferta = oferta;
	}
	
	public Habitacion() {};
	
	public Habitacion(Alojamiento alojamiento, String tipo, Integer cantidad, int n_huespedes, int precio_por_noche, int camas, boolean oferta) {
		super();
		this.alojamiento = alojamiento;
		this.tipo = tipo;
		this.cantidad = cantidad;
		this.n_huespedes = n_huespedes;
		this.precio_por_noche = precio_por_noche;
		this.camas = camas;
//		this.fechas_reserva = fechas_reserva;
		this.oferta = oferta;
	}
	
}
