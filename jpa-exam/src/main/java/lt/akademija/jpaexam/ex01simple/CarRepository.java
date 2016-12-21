package lt.akademija.jpaexam.ex01simple;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarRepository {

	@Autowired
	private javax.persistence.EntityManager em;
    /**
     * Searches database for all cars and returns list of them
     * @return
     */

    public List<CarEntity> findAll() {
       List<CarEntity> carlist = new ArrayList<>();
       carlist.add(em.find(CarEntity.class, getClass()));
    		 return carlist;
    }

    /**
     * Given particular ID of a car searches database and retrieves car information.
     * If car is not present `null` is returned.
     */
    public CarEntity find(Long id) {
        CarEntity car = new CarEntity(id, null, null);
        if(car.getId() == id){
        	return car;
        }
        return null;
    }

    /**
     * Saves or updates car information. When car with existing ID is passed then update operation is performed.
     * When id is not present new car is saved to database
     */
    public CarEntity saveOrUpdate(CarEntity e) {
        throw new UnsupportedOperationException();
    }
}
