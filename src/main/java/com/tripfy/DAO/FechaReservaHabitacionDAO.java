//package com.tripfy.DAO;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
//
//import org.springframework.stereotype.Repository;
//
//import com.tripfy.models.FechaReservaHabitacion;
//
//@Repository
//@Transactional
//public class FechaReservaHabitacionDAO {
//
//	@PersistenceContext
//	private EntityManager entityManager;
//	
//	public void create(FechaReservaHabitacion fechas_r) {
//		entityManager.persist(fechas_r);
//	}
//	
//	public void delete(FechaReservaHabitacion fechas_r) {
//		if(entityManager.contains(fechas_r)){
//			entityManager.remove(fechas_r);
//		}else {
//			entityManager.remove(entityManager.merge(fechas_r));
//		}
//	}
//	
//	public void update(FechaReservaHabitacion fechas_r) {
//		entityManager.merge(fechas_r);
//	}
//	
//	public FechaReservaHabitacion getById(int id) {
//		return entityManager.find(FechaReservaHabitacion.class, id);
//	}
//	
//	@SuppressWarnings("unchecked")
//	public List<FechaReservaHabitacion> getAll(){
//		return entityManager.createQuery("select id from FechaReservaHabitacion").getResultList();
//	}
//}
