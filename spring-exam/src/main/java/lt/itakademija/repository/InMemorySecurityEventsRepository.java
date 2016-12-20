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

	private List<RegisteredEvent> eventList;

    public InMemorySecurityEventsRepository(SequenceNumberGenerator sequenceGenerator, DateProvider dateProvider) {
        this.sequenceGenerator = sequenceGenerator;
        this.dateProvider = dateProvider;
		this.eventList = new ArrayList<RegisteredEvent>();
    }

    /*
     *  Notes for implementation:
     *  
     *  This method must use SequenceNumberGenerator#getNext() for generating ID;
     *  This method must use DateProvider#getCurrentDate() for getting dates;
     */
    @Override
    public RegisteredEvent create(EventRegistration eventRegistration) {
        String description = eventRegistration.getDescription();
        String location = eventRegistration.getLocation();
        SeverityLevel level = eventRegistration.getSeverityLevel();
		Long id = sequenceGenerator.getNext();
		Date date = dateProvider.getCurrentDate();
		
		RegisteredEvent event = new RegisteredEvent(id,date,level,location,description);
		this.eventList.add(event);
		return event;
    }

    @Override
    public List<RegisteredEvent> getEvents() {
        return eventList;
    }

    @Override
    public RegisteredEvent delete(Long id) {
    	RegisteredEvent event = new RegisteredEvent(id, null, null, null, null);
    	this.eventList.remove(event);
		return event;
    	
    }

    @Override
    public RegisteredEvent update(Long id, RegisteredEventUpdate registeredEventUpdate) {
        throw new UnsupportedOperationException("not implemented");
    }

}