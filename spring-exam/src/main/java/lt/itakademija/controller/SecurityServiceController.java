package lt.itakademija.controller;

import lt.itakademija.model.EventRegistration;
import lt.itakademija.model.RegisteredEvent;
import lt.itakademija.model.RegisteredEventUpdate;
import lt.itakademija.repository.SecurityEventsRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityServiceController {

	private final SecurityEventsRepository repository;

	@Autowired
	public SecurityServiceController(final SecurityEventsRepository repository) {
		this.repository = repository;
	}

	@RequestMapping(path = "/webapi/events", method = RequestMethod.GET)
	public List<RegisteredEvent> getRegisteredEvents() {
		return repository.getEvents();
	}

	@RequestMapping(path = "/webapi/events", method = RequestMethod.POST)
	public RegisteredEvent createEvent(EventRegistration registrationData) {
		return repository.create(registrationData);
	}

	@RequestMapping(path = "/webapi/events/{id}", method = RequestMethod.DELETE)
	public RegisteredEvent deleteEvent(@PathVariable Long id) {
		return repository.delete(id);
	}

	@RequestMapping(path = "/webapi/events/{id}", method = RequestMethod.PUT)
	public RegisteredEvent updateEvent (@PathVariable Long id, RegisteredEventUpdate updateData) {
		return repository.update(id, updateData);
	}

}
