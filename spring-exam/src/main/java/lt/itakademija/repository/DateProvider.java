package lt.itakademija.repository;

import java.util.Date;

import org.springframework.stereotype.Component;
/**
 * Date provider.
 *
 * Created by mariusg on 2016.12.19.
 */

@Component
public interface DateProvider {

    /**
     * Returns current date.
     *
     * @return current date.
     */
	
    Date getCurrentDate();

}
