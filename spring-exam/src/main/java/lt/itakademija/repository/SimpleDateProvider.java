package lt.itakademija.repository;

import java.util.Date;

import org.springframework.stereotype.Service;

/**
 * Created by mariusg on 2016.12.19.
 */
//@Repository
@Service
public class SimpleDateProvider implements DateProvider {

    @Override
    public Date getCurrentDate() {
    	return new Date();
    }
}
