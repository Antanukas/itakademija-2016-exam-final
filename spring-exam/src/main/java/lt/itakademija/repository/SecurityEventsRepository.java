package lt.itakademija.repository;

import java.util.Date;
import java.util.List;

import lt.itakademija.model.EventRegistration;
import lt.itakademija.model.RegisteredEvent;
import lt.itakademija.model.RegisteredEventUpdate;

/**
 * Security events repository.
 * 
 * @author mariusg
 */
public interface SecurityEventsRepository {

    /**
     * Returns a list of registered events.
     *
     * @return list of registered events.
     */
    List<RegisteredEvent> getEvents();

    /**
     * Creates registered event.
     *
     * @param eventRegistration event data
     * @return created event
     */
    RegisteredEvent create(EventRegistration eventRegistration);

    /**
     * Deletes a registered event.
     *
     * @param id event id
     * @return deleted event
     */
    RegisteredEvent delete(Long id);

    /**
     * Updates registered event.
     *
     * @param id event id
     * @param registeredEventUpdate data to update
     * @return updated event
     */
    RegisteredEvent update(Long id, RegisteredEventUpdate registeredEventUpdate);

    /**
     * finds registered event.
     *
     * @param id event id
     * @return event
     */
    public RegisteredEvent findOne(Long id);
    
    public List<RegisteredEvent> sortedEvents(Date dateFrom, Date dateTill, String location, String description);
}
