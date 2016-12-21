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
        //throw new UnsupportedOperationException("not implemented");
    	//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    	Date date = new Date();
    	return date;
    }
}
