package lt.itakademija.repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mariusg on 2016.12.19.
 */
public class SimpleDateProvider implements DateProvider {

    @Override
    public Date getCurrentDate() {
    	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    	Date date = new Date();
    	return date;
    }
}
