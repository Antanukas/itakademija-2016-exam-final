package lt.itakademija.repository;

import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * Created by mariusg on 2016.12.19.
 */
@Component
public class SimpleDateProvider implements DateProvider {

    private Date date;
    
    @Override
    public Date getCurrentDate() {
        date = new Date();
        return date;
    }
}
