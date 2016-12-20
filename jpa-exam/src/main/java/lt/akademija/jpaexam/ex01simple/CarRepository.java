package lt.akademija.jpaexam.ex01simple;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CarRepository {

	@Autowired
	private EntityManager em;
	
    /**
     * Searches database for all cars and returns list of them
     * @return
     */

    public List<CarEntity> findAll() {
    	Query q = em.createQuery("select p from CarEntity p");
        return q.getResultList();
    }

    /**
     * Given particular ID of a car searches database and retrieves car information.
     * If car is not present `null` is returned.
     */
    public CarEntity find(Long id) {
        return em.find(CarEntity.class, id);
    }

    /**
     * Saves or updates car information. When car with existing ID is passed then update operation is performed.
     * When id is not presesnt new car is saved to database
     */
    @Transactional
    public CarEntity saveOrUpdate(CarEntity car) {
    	if (car.getId() == null) {
            em.persist(car);
            return car;
        } else {
            CarEntity updatedCar = em.merge(car);
            em.persist(updatedCar);
            return updatedCar;
        }
    }
}
