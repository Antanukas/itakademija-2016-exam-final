package lt.itakademija.repository;


/**
 * Created by mariusg on 2016.12.19.
 */

public final class SimpleSequenceNumberGenerator implements SequenceNumberGenerator {

	private long simpleSequenceNumber;
    @Override
    public Long getNext() {
        //throw new UnsupportedOperationException("not implemented");
    	simpleSequenceNumber +=1;
    	return simpleSequenceNumber;
    }

}
