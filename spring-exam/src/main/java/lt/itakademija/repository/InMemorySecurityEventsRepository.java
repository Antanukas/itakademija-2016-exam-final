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

   
    private final SequenceNumberGenerator sequenceGenerator;

    
    private final DateProvider dateProvider;
    
    
    private List<RegisteredEvent> eventList = new ArrayList<RegisteredEvent>();;

    
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

        RegisteredEvent registeredEvent = new RegisteredEvent(sequenceGenerator.getNext(), dateProvider.getCurrentDate(), 
                eventRegistration.getSeverityLevel(), eventRegistration.getLocation(), 
                eventRegistration.getDescription());
        //System.out.println(eventRegistration.toString());
        //System.out.println(registeredEvent.toString());
     
        eventList.add(registeredEvent);
        return registeredEvent;
    }

    @Override
    public List<RegisteredEvent> getEvents() {
        return eventList;
    }

    @Override
    public RegisteredEvent delete(Long id) {
        for(RegisteredEvent registeredEvent: eventList){
            if(id.equals(registeredEvent.getId())){
                eventList.remove(registeredEvent);
                return registeredEvent;
            }
        }
        return null;
    }

    @Override
    public RegisteredEvent update(Long id, RegisteredEventUpdate registeredEventUpdate) {
        for(RegisteredEvent registeredEvent: eventList){
            if(id.equals(registeredEvent.getId())){
                registeredEvent.setSeverityLevel(registeredEventUpdate.getSeverityLevel());
                return registeredEvent;
            }
        }
        return null;
    }

}
