package lt.akademija.jpaexam.ex02associaions;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LibraryReaderRepository extends AbstractRepository<LibraryReader> {

	@Autowired
	private EntityManager entityManager;

	@Transactional
	public LibraryReader saveOrUpdate(LibraryReader e) {
		return (LibraryReader) super.save(e);
	}

	public LibraryReader find(Long id) {
		return entityManager.find(LibraryReader.class, id);
	}

}
