package lt.akademija.jpaexam.ex02associaions.book;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class BookRepository {

    @Autowired
    private EntityManager em;

    @Transactional
    public Book saveOrUpdate(Book book) {
        if (book.getId() == null) {
            em.persist(book);
            return book;
        } else {
            Book merged = em.merge(book);
            em.persist(merged);
            return merged;
        }
    }

    @Transactional(readOnly = true)
    public Book find(Long bookId) {        
        return em.find(Book.class, bookId);
    }
}
