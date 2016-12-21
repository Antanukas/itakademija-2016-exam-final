package lt.itakademija.repository;

import lt.itakademija.model.EventRegistration;
import lt.itakademija.model.RegisteredEvent;
import lt.itakademija.model.RegisteredEventUpdate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * {@link SequenceNumberGenerator} and {@link DateProvider}.
 *
 * Created by mariusg on 2016.12.19.
 */

@Repository
public final class InMemorySecurityEventsRepository implements SecurityEventsRepository {

	private final SequenceNumberGenerator sequenceGenerator;

	private final DateProvider dateProvider;

	private List<RegisteredEvent> registeredEventList = new ArrayList<>();

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

		RegisteredEvent registeredEvent = new RegisteredEvent(sequenceGenerator.getNext(),
				dateProvider.getCurrentDate(), eventRegistration.getSeverityLevel(), eventRegistration.getLocation(),
				eventRegistration.getDescription());
		registeredEventList.add(registeredEvent);

		return registeredEvent;

	}

	@Override
	public List<RegisteredEvent> getEvents() {
		return registeredEventList;

	}

	@Override
	public RegisteredEvent delete(Long id) {

		for (RegisteredEvent registeredEvent : registeredEventList) {
			if (id.equals(registeredEvent.getId())) {
				registeredEventList.remove(registeredEvent);
				return registeredEvent;
			}
		}
		return null;
	}

	@Override
	public RegisteredEvent update(Long id, RegisteredEventUpdate registeredEventUpdate) {
		for (RegisteredEvent registeredEvent : registeredEventList) {
			if (id.equals(registeredEvent.getId())) {
				RegisteredEvent registeredEventUpadated = new RegisteredEvent(registeredEvent.getId(),
						registeredEvent.getRegistrationDate(), registeredEventUpdate.getSeverityLevel(),
						registeredEvent.getLocation(), registeredEvent.getDescription());
				return registeredEventUpadated;
			}
		}
		return null;
	}

	@Override
	public RegisteredEvent getEventById(Long id) {
		for (RegisteredEvent registeredEvent : registeredEventList) {
			if (id.equals(registeredEvent.getId())) {
				return registeredEvent;
			}
		}
		return null;
	}

}
