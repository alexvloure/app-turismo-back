package com.tripfy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tripfy.DAO.AlojamientoDAO;
import com.tripfy.models.Alojamiento;

@Controller
public class AlojamientoController {
	
	@Autowired
	private AlojamientoDAO alojamientoDAO;
	
	@RequestMapping(value="/create/accommodation")
	@ResponseBody
	public String create(String nombre, String direccion, String contacto, String tipo, String descripcion, float valoracion, String caracteristicas){
		try {
			Alojamiento alojamiento = new Alojamiento();
			alojamiento.setNombre(nombre);
			alojamiento.setDireccion(direccion);
			alojamiento.setContacto(contacto);
			alojamiento.setContacto(contacto);
			alojamiento.setTipo(tipo);
			alojamiento.setDescripcion(descripcion);
			alojamiento.setValoracion(valoracion);
			alojamiento.setCaracteristicas(caracteristicas);
			alojamientoDAO.create(alojamiento);
			return "Alojamiento creado correctamente";
		} catch (Exception e) {
			return "Error en la creación del alojamiento";
		}
	}
	
	@RequestMapping(value="/delete/accommodation")
	@ResponseBody
	public String delete(int id) {
		try {
			Alojamiento alojamiento = new Alojamiento();
			alojamiento.setId(id);
			alojamientoDAO.delete(alojamiento);
			return "Alojamiento eliminado correctamente";
		} catch (Exception e) {
			return "Error al eliminar el alojamiento: "+e.toString();
		}
	}
	
	@RequestMapping(value="/update/accommodation")
	@ResponseBody
	public String update(int id, String nombre, String direccion, String contacto, String tipo, String descripcion, float valoracion, String caracteristicas) {
		try {
			Alojamiento alojamiento = alojamientoDAO.getById(id);
			alojamiento.setNombre(nombre);
			alojamiento.setDireccion(direccion);
			alojamiento.setContacto(contacto);
			alojamiento.setContacto(contacto);
			alojamiento.setTipo(tipo);
			alojamiento.setDescripcion(descripcion);
			alojamiento.setValoracion(valoracion);
			alojamiento.setCaracteristicas(caracteristicas);
			return "Alojamiento actualizado correctamente";
		} catch (Exception e) {
			return "Error al actualizar el alojamiento: "+e.toString();
		}
	}
	
	@RequestMapping(value="/get/accommodation")
	@ResponseBody
	public Alojamiento get(int id) {
		Alojamiento alojamiento = alojamientoDAO.getById(id);
		return alojamiento;	
	}
	
	@RequestMapping(value="/getAll/accommodations")
	@ResponseBody
	public List<Alojamiento> getAll() {
		List<Alojamiento> alojamientos = alojamientoDAO.getAll();
		return alojamientos;	
	}
}
