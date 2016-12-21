package lt.akademija.jpaexam.ex01simple;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CarRepository implements CarRepositoryInterface {

    @Autowired
    private EntityManager em;

    /**
     * Searches database for all cars and returns list of them
     * 
     * @return list of all cars
     */

    @Override
    public List<CarEntity> findAll() {
        TypedQuery<CarEntity> query = em.createQuery("SELECT c FROM CarEntity c", CarEntity.class);
        return query.getResultList();
    }

    /**
     * Given particular ID of a car searches database and retrieves car
     * information. If car is not present `null` is returned.
     */
    @Override
    public CarEntity find(Long id) {
        TypedQuery<CarEntity> query = em.createQuery("SELECT c FROM CarEntity c WHERE c.id = :id", CarEntity.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    /**
     * Saves or updates car information. When car with existing ID is passed
     * then update operation is performed. When id is not present new car is
     * saved to database
     */
    @Override
    @Transactional
    public CarEntity saveOrUpdate(CarEntity car) {
        if (car.getId() == null) {
            em.persist(car);
            return car;
        } else {
            CarEntity merged = em.merge(car);
            em.persist(merged);
            return merged;
        }
    }
}
