package lt.itakademija.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

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
        RegisteredEvent event = new RegisteredEvent(
                                    sequenceGenerator.getNext(), 
                                    dateProvider.getCurrentDate(), 
                                    eventRegistration.getSeverityLevel(), 
                                    eventRegistration.getLocation(), 
                                    eventRegistration.getDescription());
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
        delete(event.getId());
        
        RegisteredEvent updatedEvent = new RegisteredEvent(
                                            event.getId(), 
                                            event.getRegistrationDate(), 
                                            registeredEventUpdate.getSeverityLevel(), 
                                            event.getLocation(), 
                                            event.getDescription());
        registeredEvents.add(updatedEvent);
        return updatedEvent;
    }
    
    @Override
    public List<RegisteredEvent> getFilteredEvents(Date dateFrom, Date dateTill, String descriptionFragment, String locationFragment) {
        Stream<RegisteredEvent> filteredStream = registeredEvents.stream();
        if (dateFrom != null) {
            filteredStream = filteredStream.filter(event -> event.getRegistrationDate().after(dateFrom));
        }
        if (dateTill != null) {
            filteredStream = filteredStream.filter(event -> event.getRegistrationDate().before(dateTill));
        }
        if (descriptionFragment != null) {
            filteredStream = filteredStream.filter(event -> event.getDescription().toLowerCase().contains(descriptionFragment.toLowerCase()));
        }
        if (locationFragment != null) {
            filteredStream = filteredStream.filter(event -> event.getLocation().toLowerCase().contains(locationFragment.toLowerCase()));
        }
        return filteredStream.collect(Collectors.toList());
    }

}
