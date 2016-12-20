package lt.akademija.jpaexam.ex01simple;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class CarRepository {

    /**
     * Searches database for all cars and returns list of them
     * @return
     */
	
	@Autowired
	private EntityManager em;

    public List<CarEntity> findAll() {
        throw new UnsupportedOperationException();
        return em.createQuery("SELECT c FROM CarEntity c").getResultList();

    }

    /**
     * Given particular ID of a car searches database and retrieves car information.
     * If car is not present `null` is returned.
     */
    public CarEntity find(Long id) {
        throw new UnsupportedOperationException();
        return em.find(CarEntity.class, id);
    }

    /**
     * Saves or updates car information. When car with existing ID is passed then update operation is performed.
     * When id is not present new car is saved to database
     */
    public CarEntity saveOrUpdate(CarEntity e) {
        throw new UnsupportedOperationException();
        CarEntity car;
        if(e.getId() == null) {
        	em.persist(e);
        	car = e;
        } else {
        	CarEntity merged = em.merge(e);
        	em.persist(e);
        	car = merged;
        }
        return car;
    }
}
