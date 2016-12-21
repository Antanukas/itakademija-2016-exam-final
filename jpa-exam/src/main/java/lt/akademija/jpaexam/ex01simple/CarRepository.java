package lt.akademija.jpaexam.ex01simple;

import java.io.Serializable;
import java.util.List;

import lt.akademija.jpaexam.RepMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
public class CarRepository {

    @Autowired
    EntityManager em;

    @Autowired
    RepMethods rep;
    /**
     * Searches database for all cars and returns list of them
     * @return
     */
    @Transactional
    public List<CarEntity> findAll(){
        return em.createQuery("SELECT p from CarEntity p").getResultList();
    }

    /**
     * Given particular ID of a car searches database and retrieves car information.
     * If car is not present `null` is returned.
     */
    @Transactional
    public CarEntity find(Long id) {
       return ((CarEntity) rep.find(id, CarEntity.class.getCanonicalName()));
//        return em.find(CarEntity.class, id);
    }

    /**
     * Saves or updates car information. When car with existing ID is passed then update operation is performed.
     * When id is not present new car is saved to database
     */
    @Transactional
    public CarEntity saveOrUpdate(CarEntity e) {
        if (e.getId() == null) {
            em.persist(e);
        } else {
            CarEntity merged = em.merge(e);
            em.persist(merged);
            return merged;
        }
        return e;
    }
}
