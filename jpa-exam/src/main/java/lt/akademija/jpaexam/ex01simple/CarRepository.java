package lt.akademija.jpaexam.ex01simple;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Repository
public class CarRepository {

	@Autowired
	private EntityManager em;

	/**
	 * Given particular ID of a car searches database and retrieves car
	 * information. If car is not present `null` is returned.
	 */
	public CarEntity find(Long id) {
		if((em.find(CarEntity.class, id)) != null){
			return em.find(CarEntity.class, id);
		}
		return null;
	}

	/**
	 * Saves or updates car information. When car with existing ID is passed
	 * then update operation is performed. When id is not present new car is
	 * saved to database
	 */
	@PostMapping("/api/car")
	public CarEntity saveOrUpdate(@RequestBody CarEntity c) {

		if (c.getId() == null) {
			em.persist(c);
			return c;
		} else {
			CarEntity merged = em.merge(c);
			em.persist(merged);
			return merged;
		}

	}
	
	/**
	 * Searches database for all cars and returns list of them
	 * 
	 * @return
	 */
	@GetMapping("/api/car")
	@Transactional
	public List<CarEntity> findAll() {

		return em.createQuery("SELECT c from CarEntity c").getResultList();
		

	}

}
