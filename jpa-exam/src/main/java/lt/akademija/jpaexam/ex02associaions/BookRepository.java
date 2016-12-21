package lt.akademija.jpaexam.ex02associaions;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
	
	@Autowired
	private EntityManager em;

    public Book saveOrUpdate(Book e) {
        if(e == null){
        	throw new UnsupportedOperationException();
        }
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
    	if(bookId == null){
    		throw new UnsupportedOperationException();
    	}
        return find(bookId);
    }
}
