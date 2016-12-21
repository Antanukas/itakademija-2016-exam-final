package lt.akademija.jpaexam.ex02associaions.library;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lt.akademija.jpaexam.ex02associaions.book.Book;
import lt.akademija.jpaexam.ex02associaions.library_reader.LibraryReader;

@Entity
@Table(name = "LIBRARY")
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    /**
     * Simple name of the library
     */
    @Column(name = "NAME")
    private String name;

    /**
     * Readers are people registered to particular library.
     */
    @OneToMany
    @JoinColumn(name = "LIBRARY_ID")
    private List<LibraryReader> readers;

    /**
     * Holds all books that are available to borrow in this library
     */
    @OneToMany
    @JoinColumn(name = "LIBRARY_ID")
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
