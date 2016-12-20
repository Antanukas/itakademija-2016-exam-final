package lt.akademija.jpaexam.ex02associaions;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class BookRepository {

	@Autowired
	EntityManager entityManager;

	@Transactional
    public Book saveOrUpdate(Book e) {
		if (e.getId() == null){
        	entityManager.persist(e);
        } else {
        	Book mergedBook = entityManager.merge(e);
        	entityManager.persist(mergedBook);
        	return mergedBook;
        }
        return e;
		//throw new UnsupportedOperationException();
    }
	
	@Transactional // nebutina
    public Book find(Long bookId) {
    	Query query = entityManager.createQuery("SELECT b FROM Book b WHERE b.id = : bookId");
    	query.setParameter("bookId", bookId);
    	Book bookToReturn = (Book) query.getSingleResult();
    	return bookToReturn;
    	//throw new UnsupportedOperationException();
    }
}
