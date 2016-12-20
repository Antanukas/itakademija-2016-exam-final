package lt.akademija.jpaexam.ex02associaions;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class LibraryReaderRepository {
	
	@Autowired
	private EntityManager entityManager;
	
	@Transactional
    public LibraryReader saveOrUpdate(LibraryReader e) {
        if (e.getId() == null){
        	entityManager.persist(e);
        } else {
        	LibraryReader mergedLibraryReader = entityManager.merge(e);
        	entityManager.persist(mergedLibraryReader);
        	return mergedLibraryReader;
        }
        return e;
        //throw new UnsupportedOperationException();
    }
	
	@Transactional // nebutina
    public LibraryReader find(Long id) {
    	Query query = entityManager.createQuery("SELECT r FROM LibraryReader r WHERE r.id = : readerId");
    	query.setParameter("readerId", id);
    	LibraryReader readerToReturn = (LibraryReader) query.getSingleResult();
    	return readerToReturn;
        //throw new UnsupportedOperationException();
    }
}
