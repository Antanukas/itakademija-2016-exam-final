package lt.itakademija.repository;

import lt.itakademija.model.EventRegistration;
import lt.itakademija.model.RegisteredEvent;
import lt.itakademija.model.RegisteredEventUpdate;
import lt.itakademija.model.SeverityLevel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

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
	public final List<RegisteredEvent> events = new ArrayList<RegisteredEvent>();

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
		final SeverityLevel severityLevel = eventRegistration.getSeverityLevel();
		final String location = eventRegistration.getLocation();
		final String description = eventRegistration.getDescription();
		RegisteredEvent newRegisteredEvent = new RegisteredEvent(sequenceGenerator.getNext(),
				dateProvider.getCurrentDate(), severityLevel, location, description);
		events.add(newRegisteredEvent);
		return newRegisteredEvent;
	}

	@Override
	public List<RegisteredEvent> getEvents() {
		// throw new UnsupportedOperationException("not implemented");
		return Collections.unmodifiableList(events);
	}

	@Override
	public RegisteredEvent delete(Long id) {
		// throw new UnsupportedOperationException("not implemented");
		RegisteredEvent deleteEvent = null;

		for (RegisteredEvent event : events) {
			if (event.getId().equals(id)) {
				deleteEvent = event;
				events.remove(event);
				break;
			}
		}

		return deleteEvent;
	}

	@Override
	public RegisteredEvent update(Long id, RegisteredEventUpdate registeredEventUpdate) {
		//throw new UnsupportedOperationException("not implemented");
		RegisteredEvent updateEvent = null;
		SeverityLevel severityLevel = registeredEventUpdate.getSeverityLevel();
		for (RegisteredEvent event: events) {
			if (event.getId().equals(id)) {
						
				final Date date = event.getRegistrationDate();
				final String location = event.getLocation();
				final String description = event.getDescription(); 
				
				updateEvent = new RegisteredEvent(id, date, severityLevel,location, description);
				/*
				 public RegisteredEvent(Long id,
				            Date registrationDate,
				            SeverityLevel severityLevel,
				            String location,
				            String description)
				*/
				break;
			}
		}
		return updateEvent;
	}

}
