package lt.itakademija.repository;

import org.springframework.stereotype.Component;

/**
 * Created by mariusg on 2016.12.19.
 */
@Component
public final class SimpleSequenceNumberGenerator implements SequenceNumberGenerator {
    private Long number = 0L;

    @Override
    public Long getNext() {
        number++;
        return number;
    }

}
