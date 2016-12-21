package lt.itakademija.repository;

import java.util.Date;

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
