package lt.akademija.jpaexam.ex02associaions.library_reader;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class LibraryReaderRepository {

    @Autowired
    private EntityManager em;
    
    @Transactional
    public LibraryReader saveOrUpdate(LibraryReader reader) {
        if (reader.getId() == null) {
            em.persist(reader);
            return reader;
        } else {
            LibraryReader merged = em.merge(reader);
            em.persist(merged);
            return merged;
        }
    }

    @Transactional(readOnly = true)
    public LibraryReader find(Long id) {
        return em.find(LibraryReader.class, id);
    }
}
