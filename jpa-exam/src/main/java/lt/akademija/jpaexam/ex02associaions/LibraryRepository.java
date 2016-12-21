package lt.akademija.jpaexam.ex02associaions;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class LibraryRepository {

	@Autowired
	private EntityManager entityManager;
	
	@Transactional
    public Library saveOrUpdate(Library library) {
    	if (library.getId() == null) {
    		entityManager.persist(library);
            return library;
        } else {
            Library update = entityManager.merge(library);
            entityManager.persist(update);
            return update;
        }
    }

    public Library find(Long id) {
        return entityManager.find(Library.class, id);
    }
}