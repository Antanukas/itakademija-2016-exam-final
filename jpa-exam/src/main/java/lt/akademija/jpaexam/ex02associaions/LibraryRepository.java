package lt.akademija.jpaexam.ex02associaions;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class LibraryRepository {

	@Autowired
	private EntityManager entityManager;
	
	@Transactional
    public Library saveOrUpdate(Library e) {
        if (e.getId() == null){
        	entityManager.persist(e);
        } else {
        	Library mergedLibrary = entityManager.merge(e);
        	entityManager.persist(mergedLibrary);
        	return mergedLibrary;
        }
        return e;
    	//throw new UnsupportedOperationException();
    }

    public Library find(Long id) {
    	Query query = entityManager.createQuery("SELECT l FROM Library l WHERE l.id = :libraryId");
    	query.setParameter("libraryId", id);
    	Library libraryToReturn = (Library) query.getSingleResult();
    	return libraryToReturn;
        //throw new UnsupportedOperationException();
    }
}
