package lt.akademija.jpaexam.ex02associaions;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
	
	@Autowired
	private EntityManager em;


    public Book saveOrUpdate(Book e) {
    	if (e.getId() == null) {
            em.persist(e);
            return e;
        } else {
            Book updatedBook = em.merge(e);
            em.persist(updatedBook);
            return updatedBook;
        }
    }

    public Book find(Long bookId) {
    	return em.find(Book.class, bookId);
    }
}
