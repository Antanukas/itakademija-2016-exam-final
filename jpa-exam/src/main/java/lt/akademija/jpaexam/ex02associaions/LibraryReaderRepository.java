package lt.akademija.jpaexam.ex02associaions;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LibraryReaderRepository {
		
	@Autowired
	private EntityManager em;
	
    public LibraryReader saveOrUpdate(LibraryReader e) {
        if(e == null){
        	throw new UnsupportedOperationException();
        }
        if (e.getAddresses() == null) {
			em.persist(e);
			return e;
		} else {
			LibraryReader merged = em.merge(e);
			em.persist(merged);
			return merged;
		}
    }

    public LibraryReader find(Long id) {
    	if(id == null){
    		throw new UnsupportedOperationException();
    	} return find(id);
    }
}
