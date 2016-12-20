package lt.itakademija.repository;

/**
 * Created by mariusg on 2016.12.19.
 */
public final class SimpleSequenceNumberGenerator implements SequenceNumberGenerator {

    private long sequenceNumber;

	@Override
    public Long getNext() {
    	sequenceNumber += 1L;
		return (sequenceNumber);
		
		//throw new UnsupportedOperationException("not implemented");
    }

}
