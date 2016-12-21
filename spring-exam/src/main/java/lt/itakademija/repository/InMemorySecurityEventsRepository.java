package lt.itakademija.repository;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Repository;

import lt.itakademija.model.EventRegistration;
import lt.itakademija.model.RegisteredEvent;
import lt.itakademija.model.RegisteredEventUpdate;
import lt.itakademija.model.SeverityLevel;

/**
 * In-memory security events repository. Internally, it uses
 * {@link SequenceNumberGenerator} and {@link DateProvider}.
 *
 * Created by mariusg on 2016.12.19.
 */
@Repository
public final class InMemorySecurityEventsRepository implements SecurityEventsRepository {

    private final SequenceNumberGenerator sequenceGenerator;

    private final DateProvider dateProvider;

    private final List<RegisteredEvent> events = new CopyOnWriteArrayList<>();

    public InMemorySecurityEventsRepository(SequenceNumberGenerator sequenceGenerator, DateProvider dateProvider) {
        this.sequenceGenerator = sequenceGenerator;
        this.dateProvider = dateProvider;
    }

    /*
     * Notes for implementation:
     * 
     * This method must use SequenceNumberGenerator#getNext() for generating ID;
     * This method must use DateProvider#getCurrentDate() for getting dates;
     */
    @Override
    public RegisteredEvent create(EventRegistration eventRegistration) {
        final Long id = sequenceGenerator.getNext();
        final Date registrationDate = dateProvider.getCurrentDate();
        final SeverityLevel severityLevel = eventRegistration.getSeverityLevel();
        final String location = eventRegistration.getLocation();
        final String description = eventRegistration.getDescription();

        final RegisteredEvent registeredEvent = new RegisteredEvent(id, registrationDate, severityLevel, location,
                description);

        events.add(registeredEvent);
        return registeredEvent;
    }

    @Override
    public List<RegisteredEvent> getEvents() {
        return Collections.unmodifiableList(events);
    }

    @Override
    public RegisteredEvent getEventById(Long eventId) {
        RegisteredEvent eventFound = null;

        for (RegisteredEvent event : events) {
            if (eventId.equals(event.getId())) {
                eventFound = event;
            }
        }
        return eventFound;
    }

    @Override
    public RegisteredEvent delete(Long id) {
        RegisteredEvent eventToDelete = getEventById(id);
        events.remove(eventToDelete);
        return eventToDelete;
    }

    @Override
    public RegisteredEvent update(Long id, RegisteredEventUpdate registeredEventUpdate) {
        RegisteredEvent eventToUpdate = getEventById(id);

        eventToUpdate = new RegisteredEvent(id, eventToUpdate.getRegistrationDate(),
                registeredEventUpdate.getSeverityLevel(), eventToUpdate.getLocation(), eventToUpdate.getDescription());

        events.set(events.indexOf(getEventById(id)), eventToUpdate);

        return eventToUpdate;
    }

}
