package lt.akademija.jpaexam.ex02associaions.reader;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class LibraryReaderRepository {
	
	@Autowired
	private EntityManager em;

	@Transactional
    public LibraryReader saveOrUpdate(LibraryReader lR) {
        if(lR.getId() != null) {
        	em.persist(lR);
        	return lR;
        } else {
        	LibraryReader merged = em.merge(lR);
        	em.persist(merged);
        	return merged;
        }
	}

	@Transactional
    public LibraryReader find(Long id) {
        return em.find(LibraryReader.class, id);
    }
}
