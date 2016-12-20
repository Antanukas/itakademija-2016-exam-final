package lt.itakademija.repository;

/**
 * Created by mariusg on 2016.12.19.
 */
public final class SimpleSequenceNumberGenerator implements SequenceNumberGenerator {

	private Long sequenceNumber = 0L;

	@Override
	public Long getNext() {
		// throw new UnsupportedOperationException("not implemented");
		sequenceNumber += 1L;
		return (sequenceNumber);
	}
}
