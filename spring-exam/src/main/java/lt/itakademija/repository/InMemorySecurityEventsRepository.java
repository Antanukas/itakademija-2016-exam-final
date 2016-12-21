package lt.itakademija.repository;

import lt.itakademija.model.EventRegistration;
import lt.itakademija.model.RegisteredEvent;
import lt.itakademija.model.RegisteredEventUpdate;
import lt.itakademija.model.SeverityLevel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.autoconfigure.jdbc.metadata.DataSourcePoolMetadataProvider;
import org.springframework.stereotype.Repository;

/**
 * In-memory security events repository. Internally, it uses {@link SequenceNumberGenerator} and {@link DateProvider}.
 *
 * Created by mariusg on 2016.12.19.
 */
@Repository //prideta
public final class InMemorySecurityEventsRepository implements SecurityEventsRepository {

	
	private final List<RegisteredEvent> registeredEvents = new ArrayList<RegisteredEvent>();
	
	private final SequenceNumberGenerator sequenceGenerator;

    private final DateProvider dateProvider;
    
    

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
    	EventRegistration eReg = eventRegistration;
        RegisteredEvent registeredEvent = new RegisteredEvent(sequenceGenerator.getNext(),
        			dateProvider.getCurrentDate(), eReg.getSeverityLevel(),
        			eReg.getLocation(), eReg.getDescription()
        			);
        registeredEvents.add(registeredEvent);
        return registeredEvent;
    }
    
    @Override
    public List<RegisteredEvent> getEvents() {
        return Collections.unmodifiableList(registeredEvents);
    }

    @Override
    public RegisteredEvent delete(Long id) {
    	RegisteredEvent res = null;
        for (RegisteredEvent regEvent : registeredEvents) {
			if(id.equals(regEvent.getId())){
				res = regEvent;
				registeredEvents.remove(regEvent);
				 break;
			}
			
		}
		return res;
		
    }

    @Override
    public RegisteredEvent update(Long id, RegisteredEventUpdate registeredEventUpdate) {
    	RegisteredEvent res = null;
        for(RegisteredEvent regEvent : registeredEvents){
        	if(id.equals(regEvent.getId())){
        		res = regEvent;
        		res.setSeverityLevel(registeredEventUpdate.getSeverityLevel());
        	       
        	
        	}
        }
		return res;
    }

}
