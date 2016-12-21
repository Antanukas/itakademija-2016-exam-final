package lt.akademija.jpaexam.ex02associaions;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
            LibraryReader merged = em.merge(e);
            em.persist(merged);
            return merged;
        }
    }

    public LibraryReader find(Long id) {
    	return em.find(LibraryReader.class, id);
    }
}
