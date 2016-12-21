package lt.akademija.jpaexam.ex02associaions.library;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class LibraryRepository {

    @Autowired
    private EntityManager em;
    
    @Transactional
    public Library saveOrUpdate(Library library) {
        if (library.getId() == null) {
            em.persist(library);
            return library;
        } else {
            Library merged = em.merge(library);
            em.persist(merged);
            return merged;
        }
    }

    @Transactional(readOnly = true)
    public Library find(Long id) {        
        return em.find(Library.class, id);
    }
}
