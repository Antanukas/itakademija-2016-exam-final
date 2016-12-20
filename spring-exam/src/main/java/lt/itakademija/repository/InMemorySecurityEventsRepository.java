package lt.itakademija.repository;

import lt.itakademija.model.EventRegistration;
import lt.itakademija.model.RegisteredEvent;
import lt.itakademija.model.RegisteredEventUpdate;
import lt.itakademija.model.SeverityLevel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * In-memory security events repository. Internally, it uses {@link SequenceNumberGenerator} and {@link DateProvider}.
 *
 * Created by mariusg on 2016.12.19.
 */
public final class InMemorySecurityEventsRepository implements SecurityEventsRepository {

    private final SequenceNumberGenerator sequenceGenerator;

    private final DateProvider dateProvider;
    
    // MANO LISTAS
    List<RegisteredEvent> eventList = new ArrayList<RegisteredEvent>();

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
        Long newId = sequenceGenerator.getNext();
        Date newDate = dateProvider.getCurrentDate();
        SeverityLevel newSeverityLevel = eventRegistration.getSeverityLevel();
        String newLocation = eventRegistration.getLocation();
        String newDescription = eventRegistration.getDescription();
        
    	RegisteredEvent newEvent = new RegisteredEvent(newId, newDate, newSeverityLevel, newLocation, newDescription);
    	eventList.add(newEvent);
    	return newEvent;
    	//throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public List<RegisteredEvent> getEvents() {
        return eventList;
    	//throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public RegisteredEvent delete(Long id) {
    	RegisteredEvent objectToRemove = null;
    	for(RegisteredEvent event : eventList){
        	if (event.getId() == id){
        		objectToRemove = event;
        		break;
        	}
        }
    	eventList.remove(objectToRemove);
    	return objectToRemove;
    	//throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public RegisteredEvent update(Long id, RegisteredEventUpdate registeredEventUpdate) {
    	RegisteredEvent eventToEdit = null;
    	for(RegisteredEvent event : eventList){
        	if (event.getId() == id){
        		eventToEdit = event;
        		eventList.remove(event);
        		break;
        	}
        }
        Long newId = eventToEdit.getId();
    	Date newDate = eventToEdit.getRegistrationDate();
    	SeverityLevel newSeverityLevel = registeredEventUpdate.getSeverityLevel();
        String newLocation = eventToEdit.getLocation();
        String newDescription = eventToEdit.getDescription();
        RegisteredEvent newEvent = new RegisteredEvent(newId, newDate, newSeverityLevel, newLocation, newDescription);
        eventList.add(newEvent);
        return newEvent;
        //throw new UnsupportedOperationException("not implemented");
    }

}
