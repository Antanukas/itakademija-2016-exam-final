package lt.akademija.jpaexam.ex02associaions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class LibraryService {

    @Autowired
    private GenericRepository libraryRepository;

    @Autowired
    private LibraryReaderRepository libraryReaderRepository;

    @Autowired
    private GenericRepository bookRepository;

    
    @Transactional
    public Library getLibrary(Long id) {
        return libraryRepository.find(id, Library.class);
    }

    
    @Transactional
    public Library createLibrary(Library l) {
        return libraryRepository.saveOrUpdate(l);
    }

    @Transactional
    public LibraryReader joinNewReader(Long libraryId, LibraryReader r) {
        LibraryReader savedReader = libraryReaderRepository.saveOrUpdate(r);
        Library library = libraryRepository.find(libraryId, Library.class);
        library.getReaders().add(savedReader);

        return savedReader;
    }

    @Transactional
    public Book enterNewBook(Long libraryId, Book b) {
        Book savedBook = bookRepository.saveOrUpdate(b);
        Library library = libraryRepository.find(libraryId, Library.class);
        library.getBooks().add(savedBook);
        return savedBook;
    }

    @Transactional
    public LibraryReader borrowBook(Long bookId, Long readerId) {
        LibraryReader reader = libraryReaderRepository.find(readerId);
        Book book = bookRepository.find(bookId, Book.class);
        reader.addBorrowedBook(book);
        return reader;
    }
}
