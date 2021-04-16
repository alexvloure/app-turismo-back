package com.tripfy.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.tripfy.models.Usuario;

@Repository
@Transactional
public class UsuarioDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void create(Usuario usuario) {
		entityManager.persist(usuario);
	}
	
	public void delete(Usuario usuario) {
		if(entityManager.contains(usuario)){
			entityManager.remove(usuario);
		}else {
			entityManager.remove(entityManager.merge(usuario));
		}
	}
	
	public void update(Usuario usuario) {
		entityManager.merge(usuario);
	}
	
	public Usuario getById(int id) {
		return entityManager.find(Usuario.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> getAll(){
		return entityManager.createQuery("from Usuario").getResultList();
	}
}
