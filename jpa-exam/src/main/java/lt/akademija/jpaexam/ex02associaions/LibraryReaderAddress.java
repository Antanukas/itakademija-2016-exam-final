package lt.akademija.jpaexam.ex02associaions;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LibraryReaderAddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String street;
    private String city;
    private String zipcode;
    
  /*  @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "library_reader_id")
    private LibraryReader libraryReader;*/
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

	/*public LibraryReader getLibraryReader() {
		return libraryReader;
	}

	public void setLibraryReader(LibraryReader libraryReader) {
		this.libraryReader = libraryReader;
	}*/
    
    
}
