package lt.akademija.jpaexam.ex02associaions;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LibraryRepository {
	
	@Autowired
	EntityManager em;

	@Transactional
    public Library saveOrUpdate(Library e) {
//        throw new UnsupportedOperationException();
        if (e.getId() == null) {
            em.persist(e);
            return e;
        } else {
            Library merged = em.merge(e);
            em.persist(merged);
            return merged;
        }
    }

	@Transactional
    public Library find(Long id) {
        //throw new UnsupportedOperationException();
    	return em.find(Library.class, id);
    }
}
