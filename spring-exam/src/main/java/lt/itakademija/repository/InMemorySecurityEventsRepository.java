package lt.itakademija.repository;

import lt.itakademija.model.EventRegistration;
import lt.itakademija.model.RegisteredEvent;
import lt.itakademija.model.RegisteredEventUpdate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * In-memory security events repository. Internally, it uses {@link SequenceNumberGenerator} and {@link DateProvider}.
 *
 * Created by mariusg on 2016.12.19.
 */
@Repository
public final class InMemorySecurityEventsRepository implements SecurityEventsRepository {

    private final SequenceNumberGenerator sequenceGenerator;

    private final DateProvider dateProvider;
    
    private List<RegisteredEvent> registeredEventsList = new ArrayList<>();

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
        RegisteredEvent newRegisteredEvent = new RegisteredEvent(
        		sequenceGenerator.getNext(),
        		dateProvider.getCurrentDate(),
        		eventRegistration.getSeverityLevel(),
        		eventRegistration.getLocation(),
        		eventRegistration.getDescription());
        	registeredEventsList.add(newRegisteredEvent);
        	return newRegisteredEvent;
    }

    @Override
    public List<RegisteredEvent> getEvents() {
        return registeredEventsList;
    }

    @Override
    public RegisteredEvent delete(Long id) {
        
    	for(RegisteredEvent newRegisteredEvent : registeredEventsList) {
    		if (id.equals(newRegisteredEvent.getId())) {
    			registeredEventsList.remove(newRegisteredEvent);
    			return newRegisteredEvent;
    		}
    	}
    	return null;
    }

    @Override
    public RegisteredEvent update(Long id, RegisteredEventUpdate registeredEventUpdate) {
        for (RegisteredEvent newRegisteredEvent : registeredEventsList){
        	if(id.equals(newRegisteredEvent.getId())){
        		RegisteredEvent registeredEventUpdated = new RegisteredEvent(
        				newRegisteredEvent.getId(),
        				newRegisteredEvent.getRegistrationDate(),
        				registeredEventUpdate.getSeverityLevel(),
        				newRegisteredEvent.getLocation(),
        				newRegisteredEvent.getDescription());
        		return registeredEventUpdated;
        	}
        }
        return null;
    }

}
