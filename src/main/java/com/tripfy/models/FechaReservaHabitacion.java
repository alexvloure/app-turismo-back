//package com.tripfy.models;
//
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.ForeignKey;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//
//@Entity
//@SequenceGenerator(name="seq3", initialValue=1, allocationSize=100)
//public class FechaReservaHabitacion {
//	
//	@Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq3")
//	private int id;
//	@ManyToOne
//	@JoinColumn(name="id_alojamiento", foreignKey = @ForeignKey(name="ALOJAMIENTO_ID_FK3"))
//	private Alojamiento alojamiento;
//	@ManyToOne
//	@JoinColumn(name="name_habitacion", foreignKey = @ForeignKey(name="HABITACION_NAME_FK3"))
//	private Habitacion habitacion;
//	@Column
//	@Temporal(TemporalType.DATE)
//	private Date fecha_entrada;
//	@Column
//	@Temporal(TemporalType.DATE)
//	private Date fecha_salida;
//	
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public Alojamiento getAlojamiento() {
//		return alojamiento;
//	}
//	public void setAlojamiento(Alojamiento alojamiento) {
//		this.alojamiento = alojamiento;
//	}
//	public Habitacion getHabitacion() {
//		return habitacion;
//	}
//	public void setHabitacion(Habitacion habitacion) {
//		this.habitacion = habitacion;
//	}
//	public Date getFecha_entrada() {
//		return fecha_entrada;
//	}
//	public void setFecha_entrada(Date fecha_entrada) {
//		this.fecha_entrada = fecha_entrada;
//	}
//	public Date getFecha_salida() {
//		return fecha_salida;
//	}
//	public void setFecha_salida(Date fecha_salida) {
//		this.fecha_salida = fecha_salida;
//	}
//	
//	public FechaReservaHabitacion() {};
//	
//	public FechaReservaHabitacion(Alojamiento alojamiento, Habitacion habitacion, Date fecha_entrada,
//			Date fecha_salida) {
//		super();
//		this.alojamiento = alojamiento;
//		this.habitacion = habitacion;
//		this.fecha_entrada = fecha_entrada;
//		this.fecha_salida = fecha_salida;
//	}
//	
//	
//}
