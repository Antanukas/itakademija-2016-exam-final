package lt.itakademija.repository;

import org.springframework.stereotype.Component;

/**
 * Created by mariusg on 2016.12.19.
 */
@Component("SimpleSequenceNumberGenerator")
public final class SimpleSequenceNumberGenerator implements SequenceNumberGenerator {
	Long id = 1L;
    @Override
    public Long getNext() {
    	return id++;
        
        
    }

}
