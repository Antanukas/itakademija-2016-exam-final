package lt.akademija.jpaexam.ex02associaions;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LibraryReaderRepository {

    private EntityManager em;
    
    @Autowired
    public LibraryReaderRepository(EntityManager em) {
        this.em = em;
    }
    
    @Transactional
    public LibraryReader saveOrUpdate(LibraryReader e) {
        if (e.getId() != null && find(e.getId()) != null) {
            return em.merge(e);
        } else {
            em.persist(e);
            return e;
        }
    }

    public LibraryReader find(Long id) {
        return em.find(LibraryReader.class, id);
    }
}
