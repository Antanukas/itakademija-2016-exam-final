package lt.itakademija.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lt.itakademija.model.EventRegistration;
import lt.itakademija.model.RegisteredEvent;
import lt.itakademija.model.RegisteredEventUpdate;
import lt.itakademija.model.SeverityLevel;

/**
 * In-memory security events repository. Internally, it uses {@link SequenceNumberGenerator} and {@link DateProvider}.
 *
 * Created by mariusg on 2016.12.19.
 */
@Repository
public final class InMemorySecurityEventsRepository implements SecurityEventsRepository {

    private final SequenceNumberGenerator sequenceGenerator;

    private final DateProvider dateProvider;
    
    private List<RegisteredEvent> registeredEvents = new ArrayList<RegisteredEvent>();

    @Autowired
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
        Long id = sequenceGenerator.getNext();
        Date date = dateProvider.getCurrentDate();
        SeverityLevel severity = eventRegistration.getSeverityLevel();
        String location = eventRegistration.getLocation();
        String description = eventRegistration.getDescription();
        
        RegisteredEvent event = new RegisteredEvent(id, date, severity, location, description);
        registeredEvents.add(event);
        return event;
    }
    
    @Override
    public RegisteredEvent getEvent(Long id) {
        return registeredEvents.stream()
                    .filter(event -> event.getId() == id)
                    .findFirst()
                    .orElse(null);
    }

    @Override
    public List<RegisteredEvent> getEvents() {
        return Collections.unmodifiableList(registeredEvents);
    }

    @Override
    public RegisteredEvent delete(Long id) {
        RegisteredEvent event = getEvent(id);
        if (event == null) {
            return null;
        }
        registeredEvents.remove(event);
        return event;
    }

    @Override
    public RegisteredEvent update(Long id, RegisteredEventUpdate registeredEventUpdate) {
        RegisteredEvent event = getEvent(id);
        if (event == null) {
            return null;
        }
        Long eventId = event.getId();
        delete(eventId);
        
        Date date = event.getRegistrationDate();
        SeverityLevel severity = registeredEventUpdate.getSeverityLevel();
        String location = event.getLocation();
        String description = event.getDescription();
        
        RegisteredEvent updatedEvent = new RegisteredEvent(id, date, severity, location, description);
        registeredEvents.add(updatedEvent);
        return updatedEvent;
    }

}
