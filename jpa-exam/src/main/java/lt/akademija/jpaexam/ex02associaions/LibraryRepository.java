package lt.akademija.jpaexam.ex02associaions;

import org.springframework.stereotype.Repository;

@Repository
public class LibraryRepository extends GenericBaseRepository<Library>{

    public LibraryRepository() {
        super(Library.class);
    }

}