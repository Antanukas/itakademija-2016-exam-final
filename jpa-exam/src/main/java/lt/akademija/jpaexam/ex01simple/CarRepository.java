package lt.akademija.jpaexam.ex01simple;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarRepository {

	@Autowired
	private EntityManager manager;

	/**
	 * Searches database for all cars and returns list of them
	 * 
	 * @return
	 */
	public List<CarEntity> findAll() {
		// throw new UnsupportedOperationException();
		Query find = manager.createQuery("SELECT p FROM CarEntity p");
		List<CarEntity> carsFound = find.getResultList();
		return carsFound;
	}

	/**
	 * Given particular ID of a car searches database and retrieves car
	 * information. If car is not present `null` is returned.
	 */
	public CarEntity find(Long id) {
		// throw new UnsupportedOperationException();
		CarEntity found = manager.find(CarEntity.class, id);
		return found;
	}

	/**
	 * Saves or updates car information. When car with existing ID is passed
	 * then update operation is performed. When id is not present new car is
	 * saved to database
	 */
	@Transactional
	public CarEntity saveOrUpdate(CarEntity car) {
		// throw new UnsupportedOperationException();
		if (car.getId() == null) {
			manager.persist(car);
			return car;
		} else {
			CarEntity carUpdate = manager.merge(car);
			manager.persist(carUpdate);
			return carUpdate;
		}
	}
}