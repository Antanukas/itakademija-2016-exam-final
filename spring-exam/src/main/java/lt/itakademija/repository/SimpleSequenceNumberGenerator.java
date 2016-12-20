package lt.itakademija.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by mariusg on 2016.12.19.
 */
@Component
public final class SimpleSequenceNumberGenerator implements SequenceNumberGenerator {

	long firstSequenceNumber = 1;

	@Override
	public Long getNext() {

		return firstSequenceNumber++;

	}

}
