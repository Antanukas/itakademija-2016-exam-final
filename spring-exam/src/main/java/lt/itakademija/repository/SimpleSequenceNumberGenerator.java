package lt.itakademija.repository;

/**
 * Created by mariusg on 2016.12.19.
 */
public final class SimpleSequenceNumberGenerator implements SequenceNumberGenerator {
	
	private Long number = 1L;
	
    @Override
    public Long getNext() {
        
    	Long numberToReturn = number;
    	number +=1;
    	return numberToReturn;
    	
    	//throw new UnsupportedOperationException("not implemented");
    }

}
