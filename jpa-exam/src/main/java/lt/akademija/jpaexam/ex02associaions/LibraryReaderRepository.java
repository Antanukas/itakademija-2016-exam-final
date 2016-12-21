package lt.akademija.jpaexam.ex02associaions;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class LibraryReaderRepository {

	@Autowired
	private EntityManager em;

	@Transactional
	public LibraryReader saveOrUpdate(LibraryReader e) {
		// throw new UnsupportedOperationException();
		if (e.getBorrowedBooks()!=null){
			e.setBorrowedBooks(null);
		};
		if (e.getId() == null) {
			em.persist(e);
			return e;
		} else {
			LibraryReader merged = em.merge(e);
			em.persist(merged);
			return merged;
		}
	}

	public LibraryReader find(Long id) {
		//throw new UnsupportedOperationException();
		return em.find(LibraryReader.class, id);
	}
}
