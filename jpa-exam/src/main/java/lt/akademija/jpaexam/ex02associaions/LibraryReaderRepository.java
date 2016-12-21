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
		if (e.getId() == null) {
			em.persist(e);
			return e;
		} else {
			LibraryReader updatedLibraryReader = em.merge(e);
			em.persist(updatedLibraryReader);
			return updatedLibraryReader;
		}
	}

	public LibraryReader find(Long id) {
		return em.find(LibraryReader.class, id);
	}
}
