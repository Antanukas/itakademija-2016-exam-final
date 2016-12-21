package lt.akademija.jpaexam.ex02associaions;

import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class BookRepository {

	@Autowired
	private EntityManager manager;

	@Transactional
	public Book saveOrUpdate(Book book) {
		// throw new UnsupportedOperationException();
		if (book.getId() == null) {
			manager.persist(book);
			return book;
		} else {
			Book updatedBook = manager.merge(book);
			manager.persist(updatedBook);
			return updatedBook;
		}
	}

	public Book find(Long bookId) {
		// throw new UnsupportedOperationException();
		Book found = manager.find(Book.class, bookId);
		return found;
	}
}
