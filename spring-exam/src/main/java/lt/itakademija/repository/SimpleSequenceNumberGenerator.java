package lt.itakademija.repository;

/**
 * Created by mariusg on 2016.12.19.
 */
public final class SimpleSequenceNumberGenerator implements SequenceNumberGenerator {

	private long number;

	@Override
	public Long getNext() {
		number += 1L;
		return (number);
	}

}
