package lt.akademija.jpaexam.ex02associaions;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
	@Autowired
	/**
	 * Entity manager for managing entities or in this case books.
	 */
	private EntityManager entityManager;
	
	
	/**
	 * Saves or updates book state
	 */
	@Transactional
    public Book saveOrUpdate(Book book) {
		if (book.getId() == null) {
			entityManager.persist(book);
			return book;
		} else{
			Book update = entityManager.merge(book);
			entityManager.persist(update);
			return update;
		}
    }
	
	/**
	 * Finds book by its ID
	 */
	@Transactional
    public Book find(Long bookId) {
		Book bookFoundById = entityManager.find(Book.class, bookId);
		return bookFoundById;
    }
}
