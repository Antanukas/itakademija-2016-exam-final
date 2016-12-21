package lt.akademija.jpaexam.ex02associaions;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lt.akademija.jpaexam.ex01simple.CarEntity;

@Repository
public class LibraryRepository {

	@Autowired
	private EntityManager em;

	public Library saveOrUpdate(Library e) {

		if (e == null) {
			throw new UnsupportedOperationException();
		}
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
		if (id == null) {
			throw new UnsupportedOperationException();
		}
		return find(id);
	}
}
