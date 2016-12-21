package lt.itakademija.repository;

import org.springframework.stereotype.Component;

/**
 * Created by mariusg on 2016.12.19.
 */
@Component
public final class SimpleSequenceNumberGenerator implements SequenceNumberGenerator {
	
	private long sequenceNumber = 0;
	
    @Override
    public Long getNext() {
    	return ++sequenceNumber;
    }

}
