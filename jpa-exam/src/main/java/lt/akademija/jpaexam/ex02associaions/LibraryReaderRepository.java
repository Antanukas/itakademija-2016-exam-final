package lt.akademija.jpaexam.ex02associaions;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lt.akademija.jpaexam.ex01simple.CarEntity;

@Repository
public class LibraryReaderRepository {

	@Autowired
	private EntityManager em;
	
    public LibraryReader saveOrUpdate(LibraryReader e) {
		if (e.getId() == null) {
			em.persist(e);
			return e;
		} else {
			LibraryReader merged = em.merge(e);
			em.persist(merged);
			return merged;
		}

	
    }

    public LibraryReader find(Long id) {
		if((em.find(LibraryReader.class, id)) != null){
			return em.find(LibraryReader.class, id);
		}
		
		return null;
    }
}
