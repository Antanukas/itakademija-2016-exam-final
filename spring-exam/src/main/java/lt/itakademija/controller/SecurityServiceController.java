package lt.itakademija.controller;

import lt.itakademija.model.EventRegistration;
import lt.itakademija.model.RegisteredEvent;
import lt.itakademija.model.RegisteredEventUpdate;
import lt.itakademija.repository.InMemorySecurityEventsRepository;
import lt.itakademija.repository.SecurityEventsRepository;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/webapi/events")
public class SecurityServiceController {

	private final SecurityEventsRepository repository;

	@Autowired
	public SecurityServiceController(final SecurityEventsRepository repository) {
		this.repository = repository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<RegisteredEvent> getRegisteredEvents() {
		// throw new UnsupportedOperationException("not implemented");
		return repository.getEvents();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public RegisteredEvent createEvent(@Valid @RequestBody final EventRegistration registrationData) {
		// throw new UnsupportedOperationException("not implemented");
		
		return repository.create(registrationData);
		//return null;
	}
	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public RegisteredEvent deleteEvent(Long id) {
		// throw new UnsupportedOperationException("not implemented");
		return repository.delete(id);
		//return null;
	}

	public RegisteredEvent updateEvent(Long id, RegisteredEventUpdate updateData) {
		// throw new UnsupportedOperationException("not implemented");
		return repository.update(id, updateData);
		//return null;
	}

}
