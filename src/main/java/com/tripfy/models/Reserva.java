package com.tripfy.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name="seq6", initialValue=1, allocationSize=100)
public class Reserva {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq6")
	private int id;
	@Column
	private int cantidad;
	@Column
	private float precio;
//	@ManyToOne
//	@JoinColumn(name="id_fechaReservaHabitacion", foreignKey= @ForeignKey(name="FECHA-RESERVA-HABITACION_ID_FK6"))
//	private FechaReservaHabitacion fecha_r;
	@ManyToOne
	@JoinColumn(name="id_usuario", foreignKey = @ForeignKey(name="USUARIO_ID_FK6"))
	private Usuario usuario;
	@ManyToOne
	@JoinColumn(name="id_habitacion", foreignKey = @ForeignKey(name="HABITACION_ID_FK6"))
	private Habitacion habitacion;
//	@ManyToOne
//	@JoinColumn(name="id_alojamiento", foreignKey = @ForeignKey(name="ALOJAMIENTO_ID_FK6"))
//	private Alojamiento alojamiento;
	@Column
	@Temporal(TemporalType.DATE)
	private Date fecha_entrada;
	@Column
	@Temporal(TemporalType.DATE)
	private Date fecha_salida;
	
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
//	public FechaReservaHabitacion getFecha() {
//		return fecha_r;
//	}
//	public void setFecha(FechaReservaHabitacion fecha_r) {
//		this.fecha_r = fecha_r;
//	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Habitacion getHabitacion() {
		return habitacion;
	}
	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}
//	public Alojamiento getAlojamiento() {
//		return alojamiento;
//	}
//	public void setAlojamiento(Alojamiento alojamiento) {
//		this.alojamiento = alojamiento;
//	}
	public Date getFecha_entrada() {
		return fecha_entrada;
	}
	public void setFecha_entrada(Date fecha_entrada) {
		this.fecha_entrada = fecha_entrada;
	}
	public Date getFecha_salida() {
		return fecha_salida;
	}
	public void setFecha_salida(Date fecha_salida) {
		this.fecha_salida = fecha_salida;
	}
	
	public Reserva(){
		
	}
	
	public Reserva(int cantidad, int precio, Date fecha_entrada, Date fecha_salida) {
		super();
		this.cantidad = cantidad;
		this.precio = precio;
//		this.fecha_r = fecha_r;
		this.fecha_entrada = fecha_entrada;
		this.fecha_salida = fecha_salida;
	}
	
}
