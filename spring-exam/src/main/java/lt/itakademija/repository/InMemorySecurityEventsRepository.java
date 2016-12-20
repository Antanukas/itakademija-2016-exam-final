package lt.itakademija.repository;

import lt.itakademija.model.EventRegistration;
import lt.itakademija.model.RegisteredEvent;
import lt.itakademija.model.RegisteredEventUpdate;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Repository;

/**
 * In-memory security events repository. Internally, it uses
 * {@link SequenceNumberGenerator} and {@link DateProvider}.
 *
 * Created by mariusg on 2016.12.19.
 */
@Repository
public final class InMemorySecurityEventsRepository implements SecurityEventsRepository {

	@NotNull
	private final SequenceNumberGenerator sequenceGenerator;
	@NotNull
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
		RegisteredEvent deletedEvent = null;

		for (RegisteredEvent event : eventList) {
			if (event.getId() == id) {
				deletedEvent = event;
				eventList.remove((eventList.indexOf(event)));
				break;
			}
		}
		return deletedEvent;
	}

	@Override
	public RegisteredEvent update(Long id, RegisteredEventUpdate registeredEventUpdate) {
		// throw new UnsupportedOperationException("not implemented");
		RegisteredEvent eventUpdate = null;

		for (RegisteredEvent event : eventList) {
			if (event.getId() == id) {
				eventUpdate = new RegisteredEvent(event.getId(), event.getRegistrationDate(),
						registeredEventUpdate.getSeverityLevel(), event.getLocation(), event.getDescription());

				eventList.set((eventList.indexOf(event)), eventUpdate);
				break;
			}
		}
		return eventUpdate;
	}
}
