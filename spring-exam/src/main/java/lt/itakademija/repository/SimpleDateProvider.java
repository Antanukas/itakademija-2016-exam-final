package lt.itakademija.repository;

import java.time.Instant;
import java.util.Date;

/**
 * Created by mariusg on 2016.12.19.
 */
public class SimpleDateProvider implements DateProvider {

    @Override
    public Date getCurrentDate() {
        return Date.from(Instant.now()); 
    }
}
