package lt.itakademija.repository;

import org.springframework.stereotype.Service;

/**
 * Created by mariusg on 2016.12.19.
 */
@Service
public final class SimpleSequenceNumberGenerator implements SequenceNumberGenerator {

	private long number;

	@Override
	public Long getNext() {
		number += 1L;
		return (number);
	}

}
