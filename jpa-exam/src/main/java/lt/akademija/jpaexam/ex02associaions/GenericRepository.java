package lt.akademija.jpaexam.ex02associaions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;


@Repository
public class GenericRepository {

    @Autowired
    private EntityManager em;

    @Transactional
    public <T> T saveOrUpdate(T entity) {
        if (entity == null) {
            em.persist(entity);
            return entity;
        } else {
            T merged = em.merge(entity);
            em.persist(merged);
            return merged;
        }
    }
    @Transactional
    public <T> T find(Long id, Class<T> genericClass) {
        if ((em.find(genericClass, id) != null)){
            return (em.find(genericClass, id));
        }
        return null;
    }
}
