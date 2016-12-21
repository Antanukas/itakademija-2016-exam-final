package lt.akademija.jpaexam.ex02associaions.library;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class LibraryRepository {

	@Autowired
	private EntityManager em;
	
	@Transactional
    public Library saveOrUpdate(Library l) {
        if(l.getId() != null ) {
        	em.persist(l);
        	return l;
        } else {
        	Library merged = em.merge(l);
        	em.persist(merged);
        	return merged;
        }
    }

    public Library find(Long id) {
        return em.find(Library.class, id);
    }
}
