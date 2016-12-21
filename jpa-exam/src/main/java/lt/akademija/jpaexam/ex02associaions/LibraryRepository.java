package lt.akademija.jpaexam.ex02associaions;

import lt.akademija.jpaexam.RepMethods;
import lt.akademija.jpaexam.ex01simple.CarEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

@Repository
public class LibraryRepository {

    @Autowired
    RepMethods rep;

    @Autowired
    EntityManager em;

    @Transactional
    public Library saveOrUpdate(Library e) {
        if (e == null) {
            em.persist(e);
        } else {
            Library merged = em.merge(e);
            em.persist(merged);
            return merged;
        }
        return e;
    }

    public Library find(Long id) {
        return ((Library) rep.find(id, Library.class.getCanonicalName()));
//        return em.find(Library.class, id);
    }
}
