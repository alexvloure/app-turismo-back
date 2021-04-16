package com.tripfy.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.tripfy.models.RolUsuario;

@Repository
@Transactional
public class RolUsuarioDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void create(RolUsuario rol) {
		entityManager.persist(rol);
	}
	
	public void delete(RolUsuario rol) {
		if(entityManager.contains(rol)){
			entityManager.remove(rol);
		}else {
			entityManager.remove(entityManager.merge(rol));
		}
	}
	
	public void update(RolUsuario rol) {
		entityManager.merge(rol);
	}
	
	public RolUsuario getById(int id) {
		return entityManager.find(RolUsuario.class, id);
	}
	
	public RolUsuario getByRol(String rol) {
		return entityManager.find(RolUsuario.class, rol);
	}
	
	@SuppressWarnings("unchecked")
	public List<RolUsuario> getAll(){
		return entityManager.createQuery("from RolUsuario").getResultList();
	}
	
}
