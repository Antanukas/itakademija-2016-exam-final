package lt.akademija.jpaexam.ex02associaions;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class LibraryReaderRepository {

	@Autowired
	private EntityManager entityManager;
	
	@Transactional
    public LibraryReader saveOrUpdate(LibraryReader librarry) {
    	if (librarry.getId() == null) {
    		entityManager.persist(librarry);
            return librarry;
        } else {
            LibraryReader update = entityManager.merge(librarry);
            entityManager.persist(update);
            return update;
        }
    }

    public LibraryReader find(Long id) {
    	return entityManager.find(LibraryReader.class, id);
    }
}