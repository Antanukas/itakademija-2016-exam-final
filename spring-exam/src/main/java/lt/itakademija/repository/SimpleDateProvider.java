package lt.itakademija.repository;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by mariusg on 2016.12.19.
 */
@Component
public class SimpleDateProvider implements DateProvider {

    @Override
    public Date getCurrentDate() {
        return new Date();
    }
}
