package lt.itakademija.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by mariusg on 2016.12.19.
 */
@Component
//@Repository
public final class SimpleSequenceNumberGenerator implements SequenceNumberGenerator {
	
	private Long id = 0L;

    @Override
    public Long getNext() {
        return id += 1L;
    	//throw new UnsupportedOperationException("not implemented");
    }

}
