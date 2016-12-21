package lt.akademija.jpaexam.ex02associaions;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class LibraryReader extends BasicEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String firstName;
	private String lastName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "library_reader_id")
	private List<LibraryReaderAddress> addresses;

	@ManyToMany(cascade = CascadeType.ALL)
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

	public void addBorrowedBook(Book book) {
		book.getBookReaders().add(this);
		getBorrowedBooks().add(book);
	}
}
