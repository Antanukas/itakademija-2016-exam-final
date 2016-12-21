package lt.itakademija.repository;

/**
 * Created by mariusg on 2016.12.19.
 */
public final class SimpleSequenceNumberGenerator implements SequenceNumberGenerator {

	private Long seqNumber = 0L;
	
    @Override
    public Long getNext() {
        //throw new UnsupportedOperationException("not implemented");
    	seqNumber += 1L;
    	return seqNumber;
    }


}
