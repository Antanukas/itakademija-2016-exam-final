package lt.akademija.jpaexam.ex02associaions;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LibraryReaderRepository {

	@Autowired
	private EntityManager entityManager;

	@Transactional
	public LibraryReader saveOrUpdate(LibraryReader e) {
		if (e.getId() == null) {
			entityManager.persist(e);
			return e;
		} else {
			LibraryReader merged = entityManager.merge(e);
			entityManager.persist(merged);
			return merged;
		}
	}

	public LibraryReader find(Long id) {
		return entityManager.find(LibraryReader.class, id);
	}
}
