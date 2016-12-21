package lt.akademija.jpaexam;

import lt.akademija.jpaexam.ex01simple.CarEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by Pavel on 2016-12-21.
 */
@Repository
public class RepMethods {

    @Autowired
    EntityManager em;

    public Object find(Long id, String ent) {
        return em.createQuery("SELECT p from " + ent + " p WHERE p.id LIKE :id")
                .setParameter("id", id)
                .getResultList().get(0);
        }
// insert into car_entity (id, manufacture_date, model) values (null, ?, ?)

//    public Object saveOrUpdate(Serializable ent) {
//        System.out.println(ent.getClass());
//        Field[] fields = ent.getClass().getDeclaredFields();
//        System.out.println("\n\n\n\n\n\n\n");
//        for (Field field : fields) {
//            System.out.println(field.getName());
//        }
//        return null;
//    }
   }
