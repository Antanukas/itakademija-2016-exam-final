package lt.akademija.jpaexam.ex02associaions;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LibraryRepository {
	
	@Autowired
	private EntityManager em;

	@Transactional
    public Library saveOrUpdate(Library e) {
    	if (e.getId() == null) {
            em.persist(e);
            return e;
        } else {
            Library merged = em.merge(e);
            em.persist(merged);
            return merged;
        }
    }

    public Library find(Long id) {
    	return em.find(Library.class, id);
    }
}
