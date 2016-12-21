package lt.itakademija.repository;

import java.util.Date;

/**
 * Created by mariusg on 2016.12.19.
 */
public class SimpleDateProvider implements DateProvider {

	private Date date;
    @Override
    public Date getCurrentDate() {
    	Date data = new Date();
    	data.getDate();
        return data ;
    }
}
