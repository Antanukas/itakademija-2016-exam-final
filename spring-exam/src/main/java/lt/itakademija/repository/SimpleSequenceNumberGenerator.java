package lt.itakademija.repository;

import org.springframework.stereotype.Component;

/**
 * Created by mariusg on 2016.12.19.
 */
@Component
public final class SimpleSequenceNumberGenerator implements SequenceNumberGenerator {

    private Long number = 1L;
    private final Long sequenceStepSize = 1L;
    private Long stepCounter = 0L;

    @Override
    public Long getNext() {

        if (stepCounter == 0L) {
            stepCounter++;
            return number;
        } else {
            stepCounter++;
            number += sequenceStepSize;
            return number;
        }
    }
}
