package lt.akademija.jpaexam.ex02associaions;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {


	@Autowired
	private EntityManager entityManager;

	@Transactional
    public Book saveOrUpdate(Book e) {
		if (e.getId()==null){
			entityManager.persist(e);
			return e;
		}else {
			Book merged = entityManager.merge(e);
			entityManager.persist(merged);
			return merged;
		}
	}

    public Book find(Long bookId) {
        return entityManager.find(Book.class, bookId);
    }
}
