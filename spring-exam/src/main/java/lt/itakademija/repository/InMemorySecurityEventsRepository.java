package lt.itakademija.repository;

import lt.itakademija.model.EventRegistration;
import lt.itakademija.model.RegisteredEvent;
import lt.itakademija.model.RegisteredEventUpdate;
import lt.itakademija.model.SeverityLevel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * In-memory security events repository. Internally, it uses {@link SequenceNumberGenerator} and {@link DateProvider}.
 *
 * Created by mariusg on 2016.12.19.
 */

@Repository
public final class InMemorySecurityEventsRepository implements SecurityEventsRepository {
	@Autowired
    private final SequenceNumberGenerator sequenceGenerator;
	@Autowired
    private final DateProvider dateProvider;

    public InMemorySecurityEventsRepository(SequenceNumberGenerator sequenceGenerator, DateProvider dateProvider) {
        this.sequenceGenerator = sequenceGenerator;
        this.dateProvider = dateProvider;
    }
    /**
     * Sarasas
     */
    private List<RegisteredEvent> registeredEventList = new ArrayList<RegisteredEvent>();
    /*
     *  Notes for implementation:
     *  
     *  This method must use SequenceNumberGenerator#getNext() for generating ID;
     *  This method must use DateProvider#getCurrentDate() for getting dates;
     */
    
    @Override
    public RegisteredEvent create(EventRegistration eventRegistration) {
    	
    	Long nextID = sequenceGenerator.getNext();
        Date currentDate = dateProvider.getCurrentDate();
        String eventLoc = eventRegistration.getLocation();
        String eventDesc = eventRegistration.getDescription();
        SeverityLevel severity = eventRegistration.getSeverityLevel();
        RegisteredEvent newEvent = new RegisteredEvent(nextID, currentDate, severity,
        		eventLoc, eventDesc);
            	registeredEventList.add(newEvent);
    	return newEvent;
    }

    @Override
    public List<RegisteredEvent> getEvents() {
        return registeredEventList;
    }

    @Override
    public RegisteredEvent delete(Long eventId) {
    	RegisteredEvent deleteEvent;
    	for (RegisteredEvent eventToDelete : registeredEventList) {
         
    		if (eventToDelete.getId() == eventId) {
    			deleteEvent = eventToDelete;
            	registeredEventList.remove(deleteEvent);
                return deleteEvent;
            }
            else {
            	return null;
            }
        }
		return null;
     }
    

    @Override
    public RegisteredEvent update(Long id, RegisteredEventUpdate registeredEventUpdate) {
    	RegisteredEvent updateEvent;
    	for (RegisteredEvent event : registeredEventList){
    		  		return event;
    	}
    	 	return null;
   }
}
