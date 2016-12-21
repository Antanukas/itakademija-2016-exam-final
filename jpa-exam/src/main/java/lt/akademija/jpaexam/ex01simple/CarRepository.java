package lt.akademija.jpaexam.ex01simple;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.data.repository.CrudRepository;

@Repository
public class CarRepository extends CrudRepository<CarEntity, Long>
{

    
}
