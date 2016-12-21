package lt.itakademija.repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import lt.itakademija.repository.SimpleDateProvider;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Date provider.
 *
 * Created by mariusg on 2016.12.19.
 */
public interface DateProvider {

    /**
     * Returns current date.
     *
     * @return current date.
     */

    Date getCurrentDate();

}
