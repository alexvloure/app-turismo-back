//package com.tripfy.controller;
//
//import java.sql.Date;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.tripfy.DAO.AlojamientoDAO;
//import com.tripfy.DAO.FechaReservaHabitacionDAO;
//import com.tripfy.DAO.HabitacionDAO;
//import com.tripfy.models.Alojamiento;
//import com.tripfy.models.FechaReservaHabitacion;
//import com.tripfy.models.Habitacion;
//
//@Controller
//public class FechaReservaHabitacionController {
//
//	@Autowired
//	private FechaReservaHabitacionDAO fechasReservaHabitacionDAO;
//	
//	@Autowired
//	private AlojamientoDAO alojamientoDAO;
//	
//	@Autowired
//	private HabitacionDAO habitacionDAO;
//	
//	@RequestMapping(value="/createFechaReserva")
//	@ResponseBody
//	public String create(int id_alojamiento, int id_habitacion, Date fecha_entrada, Date fecha_salida) {
//		try {
//			FechaReservaHabitacion fechas_r = new FechaReservaHabitacion();
//			Alojamiento alojamiento = alojamientoDAO.getById(id_alojamiento);
//			Habitacion habitacion = habitacionDAO.getById(id_habitacion);
//			fechas_r.setAlojamiento(alojamiento);
//			fechas_r.setHabitacion(habitacion);
//			fechas_r.setFecha_entrada(fecha_entrada);
//			fechas_r.setFecha_salida(fecha_salida);
//			fechasReservaHabitacionDAO.create(fechas_r);
//			return "Fecha de reserva de habitacion creada correctamente";
//		} catch (Exception e) {
//			return "Error en la creación de la fecha de reserva de habitacion";
//		}
//	}
//	
//	@RequestMapping(value="/deleteFechaReserva")
//	@ResponseBody
//	public String delete(int id) {
//		try {
//			FechaReservaHabitacion fechas_r = new FechaReservaHabitacion();
//			fechas_r.setId(id);
//			fechasReservaHabitacionDAO.delete(fechas_r);
//			return "Fecha de reserva de habitación eliminada correctamente";
//		} catch (Exception e) {
//			return "Error al eliminar la fecha de reserva de habitación: "+e.toString();
//		}
//	}
//	
//	@RequestMapping(value="/updateFechaReserva")
//	@ResponseBody
//	public String update(int id, int id_alojamiento, int id_habitacion, Date fecha_entrada, Date fecha_salida) {
//		try {
//			FechaReservaHabitacion fechas_r = fechasReservaHabitacionDAO.getById(id);
//			Alojamiento alojamiento = alojamientoDAO.getById(id_alojamiento);
//			Habitacion habitacion = habitacionDAO.getById(id_habitacion);
//			fechas_r.setAlojamiento(alojamiento);
//			fechas_r.setHabitacion(habitacion);
//			fechas_r.setFecha_entrada(fecha_entrada);
//			fechas_r.setFecha_salida(fecha_salida);
//			return "Fecha de reserva de habitación actualizada correctamente";
//		} catch (Exception e) {
//			return "Error al actualizar la fecha de reserva de habitación: "+e.toString();
//		}
//	}
//	
//	@RequestMapping(value="/getFechaReserva")
//	@ResponseBody
//	public FechaReservaHabitacion get(int id) {
//		FechaReservaHabitacion fechas_r = fechasReservaHabitacionDAO.getById(id);
//		return fechas_r;	
//	}
//	
//	@RequestMapping(value="/getAllFechaReserva")
//	@ResponseBody
//	public List<FechaReservaHabitacion> getAll() {
//		List<FechaReservaHabitacion> fechas_r= fechasReservaHabitacionDAO.getAll();
//		return fechas_r;	
//	}
//}
