package lt.akademija.jpaexam.ex02associaions;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class LibraryRepository {
	@Autowired
	private EntityManager em;

	@Transactional
	public Library saveOrUpdate(Library e) {
		// throw new UnsupportedOperationException();
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
		// throw new UnsupportedOperationException();
		return em.find(Library.class, id);
	}
}
