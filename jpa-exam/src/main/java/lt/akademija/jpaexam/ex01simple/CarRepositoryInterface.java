package lt.akademija.jpaexam.ex01simple;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface CarRepositoryInterface {

    /**
     * Searches database for all cars and returns list of them
     * @return list of all cars
     */

    List<CarEntity> findAll();

    /**
     * Given particular ID of a car searches database and retrieves car information.
     * If car is not present `null` is returned.
     */
    CarEntity find(Long id);

    /**
     * Saves or updates car information. When car with existing ID is passed then update operation is performed.
     * When id is not present new car is saved to database
     */
    CarEntity saveOrUpdate(CarEntity e);

}