package lt.akademija.jpaexam.ex01simple;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarRepository {

	@Autowired
	private EntityManager entityManager;

	/**
	 * Searches database for all cars and returns list of them
	 * 
	 * @return
	 */

	public List<CarEntity> findAll() {
		return entityManager.createQuery("SELECT c from CarEntity c").getResultList();
	}

	/**
	 * Given particular ID of a car searches database and retrieves car
	 * information. If car is not present `null` is returned.
	 */
	public CarEntity find(Long id) {
		return entityManager.find(CarEntity.class, id);
	}

	/**
	 * Saves or updates car information. When car with existing ID is passed
	 * then update operation is performed. When id is not present new car is
	 * saved to database
	 */

	@Transactional
	public CarEntity saveOrUpdate(CarEntity e) {
		if (e.getId() == null) {
			entityManager.persist(e);
			return e;
		} else {
			CarEntity merged = entityManager.merge(e);
			entityManager.persist(merged);
			return merged;
		}
	}

	@Transactional
	public void delete(CarEntity carEntity) {
		entityManager.remove(carEntity);
	}
}
