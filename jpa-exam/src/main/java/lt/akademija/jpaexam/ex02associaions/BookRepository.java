package lt.akademija.jpaexam.ex02associaions;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository extends AbstractRepository<Book> {

	@Autowired
	private EntityManager entityManager;

	@Transactional
	public Book saveOrUpdate(Book e) {
		return (Book) super.save(e);
	}

	public Book find(Long bookId) {
		return entityManager.find(Book.class, bookId);
	}
}
