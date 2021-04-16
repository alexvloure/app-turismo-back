package com.tripfy.DAO;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.tripfy.models.Reserva;

@Repository
@Transactional
public class ReservaDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void create(Reserva reserva) {
		entityManager.persist(reserva);
	}
	
	public void delete(Reserva reserva) {
		if(entityManager.contains(reserva)){
			entityManager.remove(reserva);
		}else {
			entityManager.remove(entityManager.merge(reserva));
		}
	}
	
	public void update(Reserva reserva) {
		entityManager.merge(reserva);
	}
	
	public Reserva getById(int id) {
		return entityManager.find(Reserva.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Reserva> getAll(){
		return entityManager.createQuery("from Reserva").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Reserva> getByRoomAndDate(int id_habitacion, Date fechaActual){
		return entityManager.createQuery("from Reserva where id_habitacion=?0 and fecha_entrada>=?1 or fecha_salida>=?1").setParameter(0, id_habitacion).setParameter(1, fechaActual).getResultList();
	}
}
