package lt.akademija.jpaexam.ex02associaions;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Book extends BasicEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy ="borrowedBooks")
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
}
