package lt.akademija.jpaexam.ex02associaions;

import lt.akademija.jpaexam.RepMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
public class LibraryReaderRepository {

    @Autowired
    RepMethods rep;

    @Autowired
    EntityManager em;

    @Transactional
    public LibraryReader saveOrUpdate(LibraryReader e) {
        if (e == null) {
            em.persist(e);
        } else {
            LibraryReader merged = em.merge(e);
            em.persist(merged);
            return merged;
        }
        return e;
    }

    public LibraryReader find(Long id) {
        return ((LibraryReader) rep.find(id, LibraryReader.class.getCanonicalName()));
//        return em.find(LibraryReader.class, id);
    }
}
