package lt.itakademija.controller;

import lt.itakademija.model.EventRegistration;
import lt.itakademija.model.RegisteredEvent;
import lt.itakademija.model.RegisteredEventUpdate;
import lt.itakademija.repository.SecurityEventsRepository;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spring-exam")
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
	@ResponseStatus(HttpStatus.CREATED)
	public RegisteredEvent createEvent(@Valid @RequestBody EventRegistration registrationData) {
		return repository.create(registrationData);
	}

	@RequestMapping(path = "/webapi/events/{eventId}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public RegisteredEvent deleteEvent(@PathVariable Long eventId) {
		return repository.delete(eventId);
	}

	@RequestMapping(path = "/webapi/events/{eventId}", method = RequestMethod.PUT)
	public RegisteredEvent updateEvent(@PathVariable Long eventId, @Valid @RequestBody RegisteredEventUpdate updateData) {
		return repository.update(eventId, updateData);
	}

}
