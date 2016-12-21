package lt.akademija.jpaexam.ex02associaions;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class BookRepository {

	@Autowired
	private EntityManager entityManager;

	@Transactional
    public Book saveOrUpdate(Book book) {
    	if (book.getId() == null) {
    		entityManager.persist(book);
            return book;
        } else {
            Book update = entityManager.merge(book);
            entityManager.persist(update);
            return update;
        }
    }

    public Book find(Long bookId) {
    	return entityManager.find(Book.class, bookId);
    }
}