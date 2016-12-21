package lt.akademija.jpaexam.ex02associaions;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;

    @ManyToMany(mappedBy = "borrowedBooks")
    private List<LibraryReader> bookReaders;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<LibraryReader> getBookReaders() {
        if (bookReaders == null) {
            bookReaders = new ArrayList<>();
        }
        return bookReaders;
    }

    public void setBookReaders(List<LibraryReader> bookReaders) {
        this.bookReaders = bookReaders;
    }

    public void addBookReader(LibraryReader r){
        if (bookReaders == null) {
            bookReaders = new ArrayList<>();
        }
        bookReaders.add(r);
    }
}
