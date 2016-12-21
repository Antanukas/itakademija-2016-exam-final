package lt.itakademija.repository;

import lt.itakademija.model.EventRegistration;
import lt.itakademija.model.RegisteredEvent;
import lt.itakademija.model.RegisteredEventUpdate;

import java.util.ArrayList;
import java.util.List;

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
		RegisteredEvent registeredEventevent = new RegisteredEvent(sequenceGenerator.getNext(),
				dateProvider.getCurrentDate(), eventRegistration.getSeverityLevel(), eventRegistration.getLocation(),
				eventRegistration.getDescription());
		registeredEvents.add(registeredEventevent);
		return registeredEventevent;
	}

	@Override
	public List<RegisteredEvent> getEvents() {
		return registeredEvents;
	}

	@Override
	public RegisteredEvent delete(Long id) {
		RegisteredEvent delete = registeredEvents.stream().filter(x -> x.getId().equals(id)).findFirst()
				.orElse(null);
		int deleteEvent = registeredEvents.indexOf(delete);
		registeredEvents.remove(deleteEvent);
		return delete;
	}

	@Override
	public RegisteredEvent update(Long id, RegisteredEventUpdate registeredEventUpdate) {
		RegisteredEvent update = registeredEvents.stream().filter(x -> x.getId().equals(id)).findFirst()
				.orElse(null);
		registeredEventUpdate.getSeverityLevel();
		RegisteredEvent updatedEvent = new RegisteredEvent(id, update.getRegistrationDate(),
				registeredEventUpdate.getSeverityLevel(), update.getLocation(), update.getDescription());
		return updatedEvent;
	}

}