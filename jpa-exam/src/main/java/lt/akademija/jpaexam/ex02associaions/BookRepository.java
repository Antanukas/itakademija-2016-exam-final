package lt.akademija.jpaexam.ex02associaions;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    private EntityManager em;
    
    @Autowired
    public BookRepository(EntityManager em) {
        this.em = em;
    }
    
    @Transactional
    public Book saveOrUpdate(Book e) {
        if (e.getId() != null && find(e.getId()) != null) {
            return em.merge(e);
        } else {
            em.persist(e);
            return e;
        }
    }

    public Book find(Long bookId) {
        return em.find(Book.class, bookId);
    }
}
