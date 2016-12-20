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
    private EntityManager em;
    
    /**
     * Searches database for all cars and returns list of them
     * @return
     */

    public List<CarEntity> findAll() {
        String queryTxt = "SELECT c FROM CarEntity c";
        Query q = em.createQuery(queryTxt, CarEntity.class);
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
     * When id is not present new car is saved to database
     */
    
    @Transactional
    public CarEntity saveOrUpdate(CarEntity car) {
        if (car.getId() != null && find(car.getId()) != null) {
            return em.merge(car);
        } else {
            em.persist(car);
            return car;
        }
    }
}
