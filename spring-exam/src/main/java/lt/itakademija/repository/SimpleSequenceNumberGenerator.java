package lt.itakademija.repository;

import static org.hamcrest.CoreMatchers.is;

import java.util.concurrent.atomic.AtomicLong;

import org.junit.Assert;
import org.springframework.stereotype.Repository;

/**
 * Created by mariusg on 2016.12.19.
 */

@Repository //prideta
public final class SimpleSequenceNumberGenerator implements SequenceNumberGenerator {

    private final AtomicLong sequence = new AtomicLong(0);
    @Override
    public Long getNext() {
    	final long id = sequence.incrementAndGet();
    	return id;
       }

}

