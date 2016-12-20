package lt.akademija.jpaexam.ex01simple;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarRepository {

	@Autowired
	private EntityManager em;
	
    /**
     * Searches database for all cars and returns list of them
     * @return
     */

    public List<CarEntity> findAll() {
        //throw new UnsupportedOperationException();
    	Query q = em.createQuery("select p from CarEntity p");
		return q.getResultList();
    }

    /**
     * Given particular ID of a car searches database and retrieves car information.
     * If car is not present `null` is returned.
     */
    public CarEntity find(Long id) {
        throw new UnsupportedOperationException();
    	/*Query q = em.createQuery("SELECT p FROM CarEntity p WHERE p.id = :id");
        q.setParameter("id", id);
        return q.getResultList();*/
    	
    }
    


    /**
     * Saves or updates car information. When car with existing ID is passed then update operation is performed.
     * When id is not present new car is saved to database
     */
    public CarEntity saveOrUpdate(CarEntity e) {
        //throw new Unsuppmvn clean spring-boot:runortedOperationException();
    	if (e.getId() == null) {
			em.persist(e);
			return e;
		} else {
			CarEntity merged = em.merge(e);
			em.persist(merged);
			return merged;
		}
    }
    
   
    
    
}
