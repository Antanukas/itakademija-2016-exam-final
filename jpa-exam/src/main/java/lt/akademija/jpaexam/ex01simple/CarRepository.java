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
		Query sqlQuery = entityManager.createQuery("select p from CarEntity p");
		List<CarEntity> allCars = new ArrayList<CarEntity>();
		allCars = sqlQuery.getResultList();
        return allCars;
    }

    /**
     * Given particular ID of a car searches database and retrieves car information.
     * If car is not present `null` is returned.
     */
    @Transactional
    public CarEntity find(Long id) {
    	CarEntity carFoundById = entityManager.find(CarEntity.class, id);
		return carFoundById;
    }

    /**
     * Saves or updates car information. When car with existing ID is passed then update operation is performed.
     * When id is not present new car is saved to database
     */
    @Transactional
    public CarEntity saveOrUpdate(CarEntity car) {
    		if (car.getId() == null) {
    			entityManager.persist(car);
    			return car;
    		} else {
    			CarEntity update = entityManager.merge(car);
    			entityManager.persist(update);
    			return update;
    		}
    	}
    }
    

