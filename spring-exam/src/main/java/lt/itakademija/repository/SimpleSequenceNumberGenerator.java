package lt.itakademija.repository;

import org.springframework.stereotype.Repository;

/**
 * Created by mariusg on 2016.12.19.
 */
@Repository
public final class SimpleSequenceNumberGenerator implements SequenceNumberGenerator {

	private long simpleSequenceNumber;
    @Override
    public Long getNext() {
        //throw new UnsupportedOperationException("not implemented");
    	simpleSequenceNumber +=1;
    	return simpleSequenceNumber;
    }

}
