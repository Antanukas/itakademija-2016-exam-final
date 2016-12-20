package lt.itakademija.repository;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by mariusg on 2016.12.19.
 */
@Component
public class SimpleDateProvider implements DateProvider {

	@Override
	public Date getCurrentDate() {

		Date date = new Date();
		
		return date;
	}
}
