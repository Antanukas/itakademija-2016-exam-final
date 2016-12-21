package lt.itakademija.controller;

import lt.itakademija.model.EventRegistration;
import lt.itakademija.model.RegisteredEvent;
import lt.itakademija.model.RegisteredEventUpdate;
import lt.itakademija.repository.SecurityEventsRepository;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api
public class SecurityServiceController {

	private final SecurityEventsRepository repository;

	@Autowired
	public SecurityServiceController(final SecurityEventsRepository repository) {
		this.repository = repository;
	}

	@RequestMapping(path = "/webapi/events", method = RequestMethod.GET)
	@ApiOperation(value = "Get Events")
	@ResponseStatus(HttpStatus.FOUND)
	public List<RegisteredEvent> getRegisteredEvents() {
		return repository.getEvents();
		// throw new UnsupportedOperationException("not implemented");
	}

	@RequestMapping(path = "/webapi/events", method = RequestMethod.POST)
	@ApiOperation(value = "Create Eevents")
	@ResponseStatus(HttpStatus.CREATED)
	public RegisteredEvent createEvent(
			@ApiParam(value = "Event data", required = true) @Valid @RequestBody EventRegistration registrationData) {
		return repository.create(registrationData);
		// throw new UnsupportedOperationException("not implemented");
	}

	@RequestMapping(path = "/webapi/events/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete Event by ID")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public RegisteredEvent deleteEvent(@ApiParam(value = "Event ID", required = true) @PathVariable Long id) {
		// throw new UnsupportedOperationException("n ???ot implemented");
		return repository.delete(id);
	}

	@RequestMapping(path = "/webapi/events/{id}", method = RequestMethod.PUT)
	@ApiOperation(value = "Update event")
	@ResponseStatus(HttpStatus.OK)
	public RegisteredEvent updateEvent(@ApiParam(value = "Event ID", required = true) @PathVariable Long id,
			@ApiParam(value = "Updated event data", required = true) @Valid @RequestBody RegisteredEventUpdate updateData) {
		return repository.update(id, updateData);
	}

}
