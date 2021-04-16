package com.tripfy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tripfy.DAO.AlojamientoDAO;
import com.tripfy.DAO.HabitacionDAO;
import com.tripfy.models.Alojamiento;
import com.tripfy.models.Habitacion;

@Controller
public class HabitacionController {
	
	@Autowired
	private AlojamientoDAO alojamientoDAO;
	
	@Autowired
	private HabitacionDAO habitacionDAO;
	
	@RequestMapping(value="/create/room")
	@ResponseBody
	public String create(int id_alojamiento, String tipo, int cantidad, int n_huespedes, float precio_por_noche, int porcentaje_descuento, int camas){
		try {
			Habitacion habitacion = new Habitacion();
			Alojamiento alojamiento = alojamientoDAO.getById(id_alojamiento);
			habitacion.setAlojamiento(alojamiento);
			habitacion.setTipo(tipo);
			habitacion.setCantidad(cantidad);
			habitacion.setN_huespedes(n_huespedes);
			habitacion.setPrecio_por_noche(precio_por_noche);
			habitacion.setPorcentaje_descuento(porcentaje_descuento);
			habitacion.setCamas(camas);
			habitacionDAO.create(habitacion);
			return "Habitación creada correctamente";
		} catch (Exception e) {
			return "Error en la creación de la habitación";
		}
	}
	
	@RequestMapping(value="/delete/room")
	@ResponseBody
	public String delete(int id) {
		try {
			Habitacion habitacion = new Habitacion();
			habitacion.setId(id);
			habitacionDAO.delete(habitacion);
			return "Habitación eliminada correctamente";
		} catch (Exception e) {
			return "Error al eliminar la habitación: "+e.toString();
		}
	}
	
	@RequestMapping(value="/update/room")
	@ResponseBody
	public String update(int id, int id_alojamiento, String tipo, int cantidad, int n_huespedes, float precio_por_noche, int porcentaje_descuento, int camas) {
		try {
			Habitacion habitacion = habitacionDAO.getById(id);
			Alojamiento alojamiento = alojamientoDAO.getById(id_alojamiento);
			habitacion.setAlojamiento(alojamiento);
			habitacion.setTipo(tipo);
			habitacion.setCantidad(cantidad);
			habitacion.setN_huespedes(n_huespedes);
			habitacion.setPrecio_por_noche(precio_por_noche);
			habitacion.setPorcentaje_descuento(porcentaje_descuento);
			habitacion.setCamas(camas);
			return "Habitación actualizada correctamente";
		} catch (Exception e) {
			return "Error al actualizar la habitación: "+e.toString();
		}
	}
	
	@RequestMapping(value="/get/room")
	@ResponseBody
	public Habitacion get(int id) {
		Habitacion habitacion = habitacionDAO.getById(id);
		return habitacion;	
	}
	
	@RequestMapping(value="/get/roomsByAccommodation")
	@ResponseBody
	public List<Habitacion> getHabitacionByAlojamiento(int id_alojamiento) {
		List<Habitacion> habitaciones = habitacionDAO.getByAlojamiento(id_alojamiento);
		return habitaciones;	
	}
	
	@RequestMapping(value="/getAll/rooms")
	@ResponseBody
	public List<Habitacion> getAll() {
		List<Habitacion> habitaciones = habitacionDAO.getAll();
		return habitaciones;	
	}
}
