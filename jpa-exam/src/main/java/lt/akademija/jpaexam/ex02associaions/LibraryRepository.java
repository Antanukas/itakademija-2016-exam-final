package lt.akademija.jpaexam.ex02associaions;

import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class LibraryRepository {

	@Autowired
	private EntityManager manager;

	@Transactional
	public Library saveOrUpdate(Library library) {
		// throw new UnsupportedOperationException();
		if (library.getId() == null) {
			manager.persist(library);
			return library;
		} else {
			Library libraryUpdate = manager.merge(library);
			manager.persist(libraryUpdate);
			return libraryUpdate;
		}
	}

	public Library find(Long id) {
		// throw new UnsupportedOperationException();
		Library found = manager.find(Library.class, id);
		return found;
	}
}
