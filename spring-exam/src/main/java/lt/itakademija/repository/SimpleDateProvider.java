package lt.itakademija.repository;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by mariusg on 2016.12.19.
 */
public class SimpleDateProvider implements DateProvider {

    @Override
    public Date getCurrentDate() {
        return new Date();
        //Calendar.getInstance().getTime();
    	//throw new UnsupportedOperationException("not implemented");
    }
}
