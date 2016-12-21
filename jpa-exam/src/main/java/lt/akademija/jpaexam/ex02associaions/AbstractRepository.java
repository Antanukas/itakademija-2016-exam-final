package lt.akademija.jpaexam.ex02associaions;


import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractRepository<T> implements Repository<T> {
	
	@Autowired
	private EntityManager entityManager;

	@Transactional
	protected BasicEntity save(BasicEntity entity) {
		if (entity.getId() == null) {
			entityManager.persist(entity);
			return entity;
		} else {
			BasicEntity merged = entityManager.merge(entity);
			entityManager.persist(merged);
			return merged;
		}
	}
}
