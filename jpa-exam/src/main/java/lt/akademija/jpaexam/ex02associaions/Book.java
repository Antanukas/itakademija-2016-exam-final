package lt.akademija.jpaexam.ex02associaions;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Book extends BaseEntity {

    private String title;
    private String author;

    @ManyToMany
    private List<LibraryReader> bookReaders;


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
}
