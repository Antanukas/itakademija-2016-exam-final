package lt.akademija.jpaexam.ex02associaions;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import lt.akademija.javatech.product.ProductEntity;

@Repository
public class BookRepository {


	@Autowired
	EntityManager em;
	
	@Transactional
    public Book saveOrUpdate(Book e) {
        //throw new UnsupportedOperationException();
            if (e.getId() == null) {
                em.persist(e);
                return e;
            } else {
                Book updated = em.merge(e);
                em.persist(updated);
                return updated;
            }
    }

	@Transactional
    public Book find(Long bookId) {
        //throw new UnsupportedOperationException();
        return em.find(Book.class, bookId);
    }
}
