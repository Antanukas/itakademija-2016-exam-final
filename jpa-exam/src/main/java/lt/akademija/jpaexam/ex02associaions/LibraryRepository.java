package lt.akademija.jpaexam.ex02associaions;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LibraryRepository {

    private EntityManager em;
    
    @Autowired
    public LibraryRepository(EntityManager em) {
        this.em = em;
    }
    
    @Transactional
    public Library saveOrUpdate(Library e) {
        if (e.getId() != null && find(e.getId()) != null) {
            return em.merge(e);
        } else {
            em.persist(e);
            return e;
        }
    }

    public Library find(Long id) {
        return em.find(Library.class, id);
    }
}
