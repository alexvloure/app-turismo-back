package com.tripfy.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.tripfy.models.Alojamiento;

@Repository
@Transactional
public class AlojamientoDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void create(Alojamiento alojamiento) {
		entityManager.persist(alojamiento);
	}
	
	public void delete(Alojamiento alojamiento) {
		if(entityManager.contains(alojamiento)){
			entityManager.remove(alojamiento);
		}else {
			entityManager.remove(entityManager.merge(alojamiento));
		}
	}
	
	public void update(Alojamiento alojamiento) {
		entityManager.merge(alojamiento);
	}
	
	public Alojamiento getById(int id) {
		return entityManager.find(Alojamiento.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Alojamiento> getAll(){
		return entityManager.createQuery("from Alojamiento").getResultList();
	}
}
