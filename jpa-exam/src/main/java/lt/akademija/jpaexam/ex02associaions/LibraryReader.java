package lt.akademija.jpaexam.ex02associaions;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class LibraryReader extends BaseEntity {


    private String firstName;
    private String lastName;

    @OneToMany(cascade=CascadeType.ALL)
    private List<LibraryReaderAddress> addresses;
    @ManyToMany
    private List<Book> borrowedBooks;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Book> getBorrowedBooks() {
        if (borrowedBooks == null) {
            borrowedBooks = new ArrayList<>();
        }
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public List<LibraryReaderAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<LibraryReaderAddress> addresses) {
        this.addresses = addresses;
    }

    public void addBorrowedBook(Book b) {
        getBorrowedBooks().add(b);
        b.getBookReaders().add(this);
    }
}
