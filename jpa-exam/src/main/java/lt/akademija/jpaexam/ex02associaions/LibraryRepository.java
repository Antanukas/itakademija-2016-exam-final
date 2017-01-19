package lt.akademija.jpaexam.ex02associaions;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LibraryRepository {
	
	@Autowired
	private EntityManager entityManager;

	@Transactional
    public Library saveOrUpdate(Library e) {
    	if (e.getId() == null) {
    		entityManager.persist(e);
			return e;
		} else {
			Library merged = entityManager.merge(e);
			entityManager.persist(merged);
			return merged;
		}
    }

    public Library find(Long id) {
    	return entityManager.find(Library.class, id);
    }
}
