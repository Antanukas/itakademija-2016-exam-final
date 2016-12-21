package lt.akademija.jpaexam.ex02associaions;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class LibraryReaderRepository {
	@Autowired
	private EntityManager entityManager;
	@Transactional
    public LibraryReader saveOrUpdate(LibraryReader libraryReader) {
		if (libraryReader.getId() == null) 
		{
			entityManager.persist(libraryReader);
			return libraryReader;
		}
		else
		{
			LibraryReader readerUpdate = entityManager.merge(libraryReader);
			entityManager.persist(readerUpdate);
            return readerUpdate;
		}
    }

    public LibraryReader find(Long id) {
    	
    	return entityManager.find(LibraryReader.class, id);
    	
    }
}
