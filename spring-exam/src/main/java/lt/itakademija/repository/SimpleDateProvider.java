package lt.itakademija.repository;

import java.util.Date;

import org.springframework.stereotype.Repository;

/**
 * Created by mariusg on 2016.12.19.
 */
@Repository
public class SimpleDateProvider implements DateProvider {

    @Override
    public Date getCurrentDate() {
    	return new Date();
    }
}
