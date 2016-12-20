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

	private final List<RegisteredEvent> eventList = new ArrayList<RegisteredEvent>();

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
		// throw new UnsupportedOperationException("not implemented");
		RegisteredEvent newEvent = new RegisteredEvent(sequenceGenerator.getNext(), dateProvider.getCurrentDate(),
				eventRegistration.getSeverityLevel(), eventRegistration.getLocation(),
				eventRegistration.getDescription());
		this.eventList.add(newEvent);
		return newEvent;
	}

	@Override
	public List<RegisteredEvent> getEvents() {
		// throw new UnsupportedOperationException("not implemented");
		return this.eventList;
	}

	@Override
	public RegisteredEvent delete(Long id) {
		// throw new UnsupportedOperationException("not implemented");
		RegisteredEvent temporaryReturn = null;
		for (int i = 0; i < eventList.size(); i++) {
			if (eventList.get(i).getId() == id) {
				temporaryReturn = eventList.get(i);
				eventList.remove(i);
			}
		}
		return temporaryReturn;
	}

	@Override
	public RegisteredEvent update(Long id, RegisteredEventUpdate registeredEventUpdate) {
		// throw new UnsupportedOperationException("not implemented");
		int updatedId = 0;
		for (int i = 0; i < eventList.size(); i++) {
			if (eventList.get(i).getId() == id) {
				// registeredEventUpdate.getSeverityLevel(); // only one
				// updatable thing
				eventList.get(i).setSeverityLevel(registeredEventUpdate.getSeverityLevel());
				updatedId = i;
			}
		}
		return eventList.get(updatedId);
	}
}

/*
 * IDs are Long but, "for" cycles are using int not enough memory for Long, Iterator Should be used!!!!
 */
