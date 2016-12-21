package lt.itakademija.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lt.itakademija.model.EventRegistration;
import lt.itakademija.model.RegisteredEvent;
import lt.itakademija.model.RegisteredEventUpdate;

/**
 * In-memory security events repository. Internally, it uses
 * {@link SequenceNumberGenerator} and {@link DateProvider}.
 *
 * Created by mariusg on 2016.12.19.
 */
@Component
public final class InMemorySecurityEventsRepository implements SecurityEventsRepository {

	private final SequenceNumberGenerator sequenceGenerator;

	private final DateProvider dateProvider;
	
	private List<RegisteredEvent> eventList = new ArrayList<>();

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
		RegisteredEvent event = new RegisteredEvent(sequenceGenerator.getNext(), dateProvider.getCurrentDate(),
				eventRegistration.getSeverityLevel(), eventRegistration.getLocation(),
				eventRegistration.getDescription());
		eventList.add(event);
		return event;
	}

	@Override
	public List<RegisteredEvent> getEvents() {
		return eventList;
	}

	@Override
	public RegisteredEvent delete(Long id) {
		RegisteredEvent event;

		for (int i = 0; i < eventList.size(); i++) {
			if (eventList.get(i).getId().equals(id)) {
				event = eventList.get(i);
				eventList.remove(i);
				return event;
			}
		}
		return null;
	}

	@Override
	public RegisteredEvent update(Long id, RegisteredEventUpdate registeredEventUpdate) {
		for (int i = 0; i < eventList.size(); i++) {
			if (eventList.get(i).getId().equals(id)) {
				RegisteredEvent event = eventList.get(i);
				RegisteredEvent update = new RegisteredEvent(event.getId(), event.getRegistrationDate(),
						registeredEventUpdate.getSeverityLevel(), event.getLocation(), event.getDescription());
				return update;
			}
		}
		return null;
	}

}
