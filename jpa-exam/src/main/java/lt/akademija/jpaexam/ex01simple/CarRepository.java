package lt.akademija.jpaexam.ex01simple;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CarRepository {
	
	@Autowired
	private EntityManager entityManager;
	
    /**
     * Searches database for all cars and returns list of them
     * @return
     */

	@SuppressWarnings("unchecked")
	@Transactional
	public List<CarEntity> findAll() {
        Query query = entityManager.createQuery("SELECT c FROM CarEntity c");
        List<CarEntity> resultListToReturn = new ArrayList<CarEntity>();
        resultListToReturn = query.getResultList();
        return resultListToReturn;
    	//throw new UnsupportedOperationException();
    }

    /**
     * Given particular ID of a car searches database and retrieves car information.
     * If car is not present `null` is returned.
     */
	@Transactional // nebutinas
	public CarEntity find(Long id) {
    	Query query = entityManager.createQuery("SELECT c FROM CarEntity c WHERE c.id = :carId");
    	query.setParameter("carId", id);
    	CarEntity carToReturn = (CarEntity) query.getSingleResult();
    	return carToReturn;
        //throw new UnsupportedOperationException();
    }

    /**
     * Saves or updates car information. When car with existing ID is passed then update operation is performed.
     * When id is not present new car is saved to database
     */
	@Transactional
	public CarEntity saveOrUpdate(CarEntity e) {
        if (e.getId() == null){
        	entityManager.persist(e);
        } else {
        	CarEntity mergedCar = entityManager.merge(e);
        	entityManager.persist(mergedCar);
        	return mergedCar;
        }
    	return e;
    	//throw new UnsupportedOperationException();
    }
}
