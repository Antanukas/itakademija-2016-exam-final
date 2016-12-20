package lt.akademija.jpaexam.ex02associaions;

import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class LibraryReaderRepository {

	@Autowired
	private EntityManager manager;

	@Transactional
	public LibraryReader saveOrUpdate(LibraryReader reader) {
		// throw new UnsupportedOperationException();
		if (reader.getId() == null) {
			manager.persist(reader);
			return reader;
		} else {
			LibraryReader libraryReaderUpdate = manager.merge(reader);
			manager.persist(libraryReaderUpdate);
			return libraryReaderUpdate;
		}
	}

	public LibraryReader find(Long id) {
		// throw new UnsupportedOperationException();
		LibraryReader foundReader = manager.find(LibraryReader.class, id);
		return foundReader;
	}
}
