package com.tripfy.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.tripfy.models.Habitacion;

@Repository
@Transactional
public class HabitacionDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void create(Habitacion alojamiento) {
		entityManager.persist(alojamiento);
	}
	
	public void delete(Habitacion habitacion) {
		if(entityManager.contains(habitacion)){
			entityManager.remove(habitacion);
		}else {
			entityManager.remove(entityManager.merge(habitacion));
		}
	}
	
	public void update(Habitacion habitacion) {
		entityManager.merge(habitacion);
	}
	
	public Habitacion getById(int id) {
		return entityManager.find(Habitacion.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Habitacion> getByAlojamiento(int id_alojamiento) {
		return entityManager.createQuery("from Habitacion where id_alojamiento = ?0").setParameter(0, id_alojamiento).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Habitacion> getAll(){
		return entityManager.createQuery("from Habitacion").getResultList();
	}
}
