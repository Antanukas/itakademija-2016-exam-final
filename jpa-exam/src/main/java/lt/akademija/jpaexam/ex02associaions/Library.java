package lt.akademija.jpaexam.ex02associaions;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Library extends BaseEntity {

    /**
     * Simple name of the library
     */
    private String name;

    /**
     * Readers are people registered to particular library.
     */
    @OneToMany
    private List<LibraryReader> readers;

    /**
     * Holds all books that are available to borrow in this library
     */
    @OneToMany
    private List<Book> books;


    public List<LibraryReader> getReaders() {
        return readers;
    }

    public void setReaders(List<LibraryReader> readers) {
        this.readers = readers;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
