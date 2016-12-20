package lt.itakademija.repository;

import lt.itakademija.model.EventRegistration;
import lt.itakademija.model.RegisteredEvent;
import lt.itakademija.model.RegisteredEventUpdate;

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

	private List<RegisteredEvent> eventsList = new ArrayList<RegisteredEvent>();

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
		RegisteredEvent newRegisteredEvent = new RegisteredEvent(sequenceGenerator.getNext(), dateProvider.getCurrentDate(),
				eventRegistration.getSeverityLevel(), eventRegistration.getLocation(),
				eventRegistration.getDescription());
		this.eventsList.add(newRegisteredEvent);
		return newRegisteredEvent;
	}

	@Override
	public List<RegisteredEvent> getEvents() {
		return this.eventsList;
	}

	@Override
	public RegisteredEvent delete(Long id) {
		RegisteredEvent delete = null;
		for (int i = 0; i < eventsList.size(); i++) {
			if (eventsList.get(i).getId() == id) {
				delete = eventsList.get(i);
				eventsList.remove(i);
			}
		}
		return delete;				
	}

	@Override
	public RegisteredEvent update(Long id, RegisteredEventUpdate registeredEventUpdate) {

		throw new UnsupportedOperationException("not implemented");
	}

}
