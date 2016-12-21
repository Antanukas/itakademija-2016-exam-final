package lt.itakademija.repository;

import lt.itakademija.model.EventRegistration;
import lt.itakademija.model.RegisteredEvent;
import lt.itakademija.model.RegisteredEventUpdate;

import static lt.itakademija.model.SeverityLevel.HIGH;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * In-memory security events repository. Internally, it uses {@link SequenceNumberGenerator} and {@link DateProvider}.
 *
 * Created by mariusg on 2016.12.19.
 */
public final class InMemorySecurityEventsRepository implements SecurityEventsRepository {

    private final SequenceNumberGenerator sequenceGenerator;

    private final DateProvider dateProvider;

    List<RegisteredEvent> list = new ArrayList<>();

    public InMemorySecurityEventsRepository(SequenceNumberGenerator sequenceGenerator, DateProvider dateProvider) {
        this.sequenceGenerator = sequenceGenerator;
        this.dateProvider = dateProvider;
    }

    /*
     *  Notes for implementation:
     *  
     *  This method must use SequenceNumberGenerator#getNext() for generating ID;
     *  This method must use DateProvider#getCurrentDate() for getting dates;
     */
    @Override
    public RegisteredEvent create(EventRegistration eventRegistration) {

    	return null  ;
        
    }

    @Override
    public List<RegisteredEvent> getEvents() {

		return list;
        
    }

    @Override
    public RegisteredEvent delete(Long id) {
    	
    	List<RegisteredEvent> list = new ArrayList<>();
    	list.remove(id);
    	
		return null;
    }

    @Override
    public RegisteredEvent update(Long id, RegisteredEventUpdate registeredEventUpdate) {
    	
    	
        return null;
    }

}
