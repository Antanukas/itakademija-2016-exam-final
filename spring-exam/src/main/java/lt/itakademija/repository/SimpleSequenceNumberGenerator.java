package lt.itakademija.repository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.sound.midi.Sequence;

/**
 * Created by mariusg on 2016.12.19.
 */
public final class SimpleSequenceNumberGenerator implements SequenceNumberGenerator {

    @Override
    public Long getNext() {
    	
    	SequenceNumberGenerator seqGen = mock(SequenceNumberGenerator.class);
    	
    
    	return seqGen.getNext();
       
    }
  


}
