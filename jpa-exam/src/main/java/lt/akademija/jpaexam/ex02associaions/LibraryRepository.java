package lt.akademija.jpaexam.ex02associaions;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class LibraryRepository extends AbstractRepository<Library> {

	@Autowired
	private EntityManager entityManager;

	@Transactional
	public Library saveOrUpdate(Library e) {
		return (Library) super.save(e);
	}

	public Library find(Long id) {
		return entityManager.find(Library.class, id);
	}
}
