package lt.itakademija.repository;

import lt.itakademija.model.EventRegistration;
import lt.itakademija.model.RegisteredEvent;
import lt.itakademija.model.RegisteredEventUpdate;
import lt.itakademija.model.SeverityLevel;

import java.util.ArrayList;
import java.util.List;

/**
 * In-memory security events repository. Internally, it uses
 * {@link SequenceNumberGenerator} and {@link DateProvider}.
 *
 * Created by mariusg on 2016.12.19.
 */
public final class InMemorySecurityEventsRepository implements SecurityEventsRepository {

	private final SequenceNumberGenerator sequenceGenerator;

	private final DateProvider dateProvider;

	private List<RegisteredEvent> registeredEvents = new ArrayList<>();

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
		RegisteredEvent event = new RegisteredEvent(sequenceGenerator.getNext(), dateProvider.getCurrentDate(),
				eventRegistration.getSeverityLevel(), eventRegistration.getLocation(),
				eventRegistration.getDescription());
		registeredEvents.add(event);
		return event;
	}

	@Override
	public List<RegisteredEvent> getEvents() {
		return registeredEvents;
	}

	@Override
	public RegisteredEvent delete(Long id) {
		RegisteredEvent deleteEvent = registeredEvents.stream().filter(p -> p.getId().equals(id)).findFirst()
				.orElseThrow(() -> new RuntimeException());
		int deleteEventIndex = registeredEvents.indexOf(deleteEvent);
		registeredEvents.remove(deleteEventIndex);
		return deleteEvent;
	}

	@Override
	public RegisteredEvent update(Long id, RegisteredEventUpdate registeredEventUpdate) {
		RegisteredEvent eventToUpdate = registeredEvents.stream().filter(p -> p.getId().equals(id)).findFirst()
				.orElseThrow(() -> new RuntimeException());
		registeredEventUpdate.getSeverityLevel();
		RegisteredEvent updatedEvent = new RegisteredEvent(id, eventToUpdate.getRegistrationDate(),
				registeredEventUpdate.getSeverityLevel(), eventToUpdate.getLocation(), eventToUpdate.getDescription());
		return updatedEvent;
	}

}
