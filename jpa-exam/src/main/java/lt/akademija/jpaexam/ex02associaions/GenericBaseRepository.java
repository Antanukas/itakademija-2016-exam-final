package lt.akademija.jpaexam.ex02associaions;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericBaseRepository<T extends BaseEntity> {
    
    @Autowired
    private EntityManager em;
    private Class<T> type;
    
    
    public GenericBaseRepository(Class<T> type) {
        this.type = type;
    }
    
    @Transactional
    public T saveOrUpdate(T e) {
        if (e.getId() != null && find(e.getId()) != null) {
            return em.merge(e);
        } else {
            em.persist(e);
            return e;
        }
    }

    public T find(Long id) {
        return em.find(type, id);
    }
    
}
