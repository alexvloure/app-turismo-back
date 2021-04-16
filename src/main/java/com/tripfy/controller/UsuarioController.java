package com.tripfy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tripfy.DAO.RolUsuarioDAO;
import com.tripfy.DAO.UsuarioDAO;
import com.tripfy.models.RolUsuario;
import com.tripfy.models.Usuario;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private RolUsuarioDAO rolUsuarioDAO;
	
	@RequestMapping(value="/create/user")
	@ResponseBody
	public String create(String rol_name, String nombre, String apellidos, String direccion, int telefono) {
		try {
			Usuario usuario = new Usuario();
			RolUsuario rol = rolUsuarioDAO.getByRol(rol_name);
			usuario.setRol(rol);
			usuario.setNombre(nombre);
			usuario.setApellidos(apellidos);
			usuario.setDireccion(direccion);
			usuario.setTelefono(telefono);
			usuarioDAO.create(usuario);
			return "Usuario creado correctamente";
		} catch (Exception e) {
			return "Error en la creación del usuario";
		}
	}
	
	@RequestMapping(value="/delete/user")
	@ResponseBody
	public String delete(int id) {
		try {
			Usuario usuario = new Usuario();
			usuario.setId(id);
			usuarioDAO.delete(usuario);
			return "Usuario eliminado correctamente";
		} catch (Exception e) {
			return "Error al eliminar el usuario: "+e.toString();
		}
	}
	
	@RequestMapping(value="/update/user")
	@ResponseBody
	public String update(int id, RolUsuario rol, String nombre, String apellidos, String direccion, int telefono) {
		try {
			Usuario usuario = usuarioDAO.getById(id);
			usuario.setRol(rol);
			usuario.setNombre(nombre);
			usuario.setApellidos(apellidos);
			usuario.setDireccion(direccion);
			usuario.setTelefono(telefono);
			usuarioDAO.update(usuario);
			return "Usuario actualizado correctamente";
		} catch (Exception e) {
			return "Error al actualizar el usuario: "+e.toString();
		}
	}
	
	@RequestMapping(value="/get/user")
	@ResponseBody
	public Usuario get(int id) {
			Usuario usuario = usuarioDAO.getById(id);
			return usuario;
	}
	
	@RequestMapping(value="/getAll/users")
	@ResponseBody
	public List<Usuario> getAll() {
		List<Usuario> usuarios = usuarioDAO.getAll();
		return usuarios;	
	}
}













