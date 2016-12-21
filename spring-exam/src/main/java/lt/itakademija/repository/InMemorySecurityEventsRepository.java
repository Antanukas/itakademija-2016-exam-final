package lt.itakademija.repository;

import lt.itakademija.model.EventRegistration;
import lt.itakademija.model.RegisteredEvent;
import lt.itakademija.model.RegisteredEventUpdate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

	private List<RegisteredEvent> registeredEvents;

	@Autowired
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
		if (registeredEvents == null) {
			registeredEvents = new ArrayList<RegisteredEvent>();
		}

		RegisteredEvent registeredEvent = new RegisteredEvent(this.sequenceGenerator.getNext(),
				this.dateProvider.getCurrentDate(), eventRegistration.getSeverityLevel(),
				eventRegistration.getLocation(), eventRegistration.getDescription());

		registeredEvents.add(registeredEvent);
		return registeredEvent;
	}

	@Override
	public List<RegisteredEvent> getEvents() {
		return registeredEvents;
	}

	@Override
	public RegisteredEvent delete(Long id) {
		for (RegisteredEvent registeredEvent : registeredEvents) {
			if (id.equals(registeredEvent.getId())) {
				RegisteredEvent removedEvent = registeredEvent;
				registeredEvents.remove(removedEvent);
				return removedEvent;
			}

		}
		return null;
	}

	@Override
	public RegisteredEvent update(Long id, RegisteredEventUpdate registeredEventUpdate) {
		for (RegisteredEvent registeredEvent : registeredEvents) {
			if (id.equals(registeredEvent.getId())) {
				registeredEvent.setSeverityLevel(registeredEventUpdate.getSeverityLevel());
				RegisteredEvent updatedEvent = registeredEvent;
				return updatedEvent;
			}

		}
		return null;
	}

	public RegisteredEvent findOne(Long id) {
		for (RegisteredEvent event : registeredEvents) {
			if (id.equals(event.getId())) {
				return event;
			}
		}
		return null;
	}

	public List<RegisteredEvent> sortedEvents(Date dateFrom, Date dateTill, String location, String description){
		List<RegisteredEvent> events = getEvents();
		for(RegisteredEvent event: events){
			if(event.getRegistrationDate().before(dateFrom) || 
			   event.getRegistrationDate().after(dateTill) ||
			   !event.getLocation().equals(location) ||
			   !event.getDescription().equals(description)
			){
				events.remove(event);
			}
		}
		return events;
	}

}
