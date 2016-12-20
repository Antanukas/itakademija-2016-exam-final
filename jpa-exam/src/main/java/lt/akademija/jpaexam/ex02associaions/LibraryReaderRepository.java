package lt.akademija.jpaexam.ex02associaions;

import org.springframework.stereotype.Repository;

@Repository
public class LibraryReaderRepository extends GenericBaseRepository<LibraryReader>{

    public LibraryReaderRepository() {
        super(LibraryReader.class);
    }

}