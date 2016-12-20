package lt.akademija.jpaexam.ex02associaions;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Library {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
