package lt.akademija.jpaexam.ex01simple;

import java.util.Date; 

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

@Entity
public class CarEntity {
	@Id
    private Long id;
    private String model;
    private Date manufactureDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }
}
