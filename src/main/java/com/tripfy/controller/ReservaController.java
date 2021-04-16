package com.tripfy.controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tripfy.DAO.HabitacionDAO;
import com.tripfy.DAO.ReservaDAO;
import com.tripfy.DAO.UsuarioDAO;
import com.tripfy.models.Habitacion;
import com.tripfy.models.Reserva;
import com.tripfy.models.Usuario;

@Controller
public class ReservaController {
	
	@Autowired
	private ReservaDAO reservaDAO;
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
//	@Autowired
//	private AlojamientoDAO alojamientoDAO;
	
	@Autowired
	private HabitacionDAO habitacionDAO;
	
	
	@RequestMapping(value="/create/reserva")
	@ResponseBody
	public String create(int cantidad, float precio, Date fecha_entrada, Date fecha_salida, int id_usuario, int id_habitacion){
		try {
			Reserva reserva = new Reserva();
			Usuario usuario = usuarioDAO.getById(id_usuario);
			Habitacion habitacion = habitacionDAO.getById(id_habitacion);
//			Alojamiento alojamiento = alojamientoDAO.getById(id_alojamiento); int id_alojamiento
			reserva.setCantidad(cantidad);
			reserva.setPrecio(precio);
			reserva.setUsuario(usuario);
			reserva.setHabitacion(habitacion);
//			reserva.setAlojamiento(alojamiento);
			reserva.setFecha_entrada(fecha_entrada);
			reserva.setFecha_salida(fecha_salida);
			reservaDAO.create(reserva);
			return "Reserva creada correctamente";
		} catch (Exception e) {
			return "Error en la creación de la reserva";
		}
	}
	
	@RequestMapping(value="/delete/reserva")
	@ResponseBody
	public String delete(int id) {
		try {
			Reserva reserva = new Reserva();
			reserva.setId(id);
			reservaDAO.delete(reserva);
			return "Reserva eliminada correctamente";
		} catch (Exception e) {
			return "Error al eliminar la reserva: "+e.toString();
		}
	}
	
	@RequestMapping(value="/get/reserva")
	@ResponseBody
	public Reserva get(int id) {
		Reserva reserva = reservaDAO.getById(id);
		return reserva;	
	}
	
	@RequestMapping(value="/getAll/reservas")
	@ResponseBody
	public List<Reserva> getAll() {
		List<Reserva> reservas = reservaDAO.getAll();
		return reservas;	
	}
	
	@RequestMapping(value="/get/reservasActuales")
	@ResponseBody
	public List<Reserva> getListReserva(int id){
		Date fecha = new Date();
		List<Reserva> reservas = reservaDAO.getByRoomAndDate(id, fecha);
		return reservas;
	}
}
