package com.tripfy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tripfy.DAO.RolUsuarioDAO;
import com.tripfy.models.RolUsuario;

@Controller
public class RolUsuarioController {

	@Autowired
	private RolUsuarioDAO rolUsuarioDAO;
	
	@RequestMapping(value="/create/role")
	@ResponseBody
	public String create(String rol) {
		try {
			RolUsuario rolUsuario = new RolUsuario();
			rolUsuario.setRol(rol);
			rolUsuarioDAO.create(rolUsuario);
			return "Rol creado correctamente";
		} catch (Exception e) {
			return "Error en la creación del rol";
		}
	}
	
	@RequestMapping(value="/delete/role")
	@ResponseBody
	public String delete(int id) {
		try {
			RolUsuario rolUsuario = new RolUsuario();
			rolUsuario.setId(id);
			rolUsuarioDAO.delete(rolUsuario);
			return "Rol eliminado correctamente";
		} catch (Exception e) {
			return "Error al eliminar el rol: "+e.toString();
		}
	}
	
	@RequestMapping(value="/update/role")
	@ResponseBody
	public String update(int id, String rol) {
		try {
			RolUsuario rolUsuario = rolUsuarioDAO.getById(id);
			rolUsuario.setRol(rol);
			rolUsuarioDAO.update(rolUsuario);
			return "Rol actualizado correctamente";
		} catch (Exception e) {
			return "Error al actualizar el rol: "+e.toString();
		}
	}
	
	@RequestMapping(value="/get/role")
	@ResponseBody
	public RolUsuario get(int id) {
			RolUsuario rolUsuario = rolUsuarioDAO.getById(id);
			return rolUsuario;
	}
	
	@RequestMapping(value="/getAll/roles")
	@ResponseBody
	public List<RolUsuario> getAll() {
		List<RolUsuario> roles = rolUsuarioDAO.getAll();
		return roles;	
	}
}
