package lt.akademija.jpaexam.ex02associaions;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository extends GenericBaseRepository<Book>{

    public BookRepository() {
        super(Book.class);
    }

}