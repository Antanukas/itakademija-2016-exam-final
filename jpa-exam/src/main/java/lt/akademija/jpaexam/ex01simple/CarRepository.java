package lt.akademija.jpaexam.ex01simple;

import java.util.List;

import javax.persistence.EntityManager;

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
	
	@Transactional
    public List<CarEntity> findAll() {
        return em.createQuery("SELECT c from CarEntity c").getResultList();
    }

    /**
     * Given particular ID of a car searches database and retrieves car information.
     * If car is not present `null` is returned.
     */
	@Transactional
    public CarEntity find(Long id) {
       return em.find(CarEntity.class, id);
    }

    /**
     * Saves or updates car information. When car with existing ID is passed then update operation is performed.
     * When id is not present new car is saved to database
     */
	@Transactional
    public CarEntity saveOrUpdate(CarEntity e) {
        if(e.getId() != null) {
        	em.merge(e);
        	return e;
        } else {
        	CarEntity merged = em.merge(e);
        	em.merge(merged);
        	return merged;
        }
    }
}
