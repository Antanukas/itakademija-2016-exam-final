package lt.akademija.jpaexam.ex02associaions;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;


@Repository
public class LibraryReaderRepository extends CrudRepository<Library, Long>  {
}
