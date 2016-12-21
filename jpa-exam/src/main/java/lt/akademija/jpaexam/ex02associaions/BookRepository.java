package lt.akademija.jpaexam.ex02associaions;

import lt.akademija.jpaexam.RepMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
public class BookRepository {

    @Autowired
    RepMethods rep;

    @Autowired
    EntityManager em;

    @Transactional
    public Book saveOrUpdate(Book e) {
        if (e == null) {
            em.persist(e);
        } else {
            Book merged = em.merge(e);
            em.persist(merged);
            return merged;
        }
        return e;
    }

    @Transactional
    public Book find(Long bookId) {
        return ((Book) rep.find(bookId, Book.class.getCanonicalName()));
//        return em.find(Book.class, bookId);
    }
}
