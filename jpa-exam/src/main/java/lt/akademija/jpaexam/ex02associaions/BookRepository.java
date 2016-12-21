package lt.akademija.jpaexam.ex02associaions;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class BookRepository {

	@Autowired
	private EntityManager em;

	@Transactional
	public Book saveOrUpdate(Book e) {
		// throw new UnsupportedOperationException();
		if (e.getId() == null) {
			em.persist(e);
			return e;
		} else {
			Book merged = em.merge(e);
			em.persist(merged);
			return merged;
		}
	}

	public Book find(Long bookId) {
		//throw new UnsupportedOperationException();
		return em.find(Book.class, bookId);
	}
}
