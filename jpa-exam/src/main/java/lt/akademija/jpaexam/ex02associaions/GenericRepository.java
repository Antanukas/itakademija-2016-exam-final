package lt.akademija.jpaexam.ex02associaions;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class GenericRepository {

	private static ClassLoader cl = ClassLoader.getSystemClassLoader();
	
	@Autowired
	EntityManager em;
	
	@Transactional
    public Class saveOrUpdate(Object o) throws ClassNotFoundException {
		Class k = Class.forName(o.getClass().toString());
		Object returner = k.cast(o);
		
		// sumanymo esme - is gaunamo paramso istraukti jo Class ir perduoti
		// i EntityManager, return type ir t.t.
		
		Class klass;
		/*if (k.getId() == null) {
			em.persist(k);
			book = e;
		} else {
			Book merged = em.merge(e);
			em.persist(merged);
			book = merged;
		}*/
		
		return (Class) returner;
		
		
		
		
		/*Book book;
    	
    	return book;*/
    }

	/*@Transactional(readOnly = true)
    public Book find(Long bookId) {
        //throw new UnsupportedOperationException();
		return em.find(Book.class, bookId);
    }*/
}
