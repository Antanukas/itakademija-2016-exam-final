package lt.akademija.jpaexam.ex02associaions;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

	@Autowired
	private EntityManager em;
	
    public Book saveOrUpdate(Book e) {
		if (e.getId() == null) {
			em.persist(e);
			return e;
		} else {
			Book merged = em.merge(e);
			em.persist(merged);
			return merged;
		}

	
    }
    

    public Book find(Long bookId) {
		if((em.find(Book.class, bookId)) != null){
			return em.find(Book.class, bookId);
		}
		
		return null;
    }
    
}
