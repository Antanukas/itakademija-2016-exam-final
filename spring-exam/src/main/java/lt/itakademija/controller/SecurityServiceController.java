package lt.itakademija.controller;

import lt.itakademija.model.EventRegistration;
import lt.itakademija.model.RegisteredEvent;
import lt.itakademija.model.RegisteredEventUpdate;
import lt.itakademija.repository.SecurityEventsRepository;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Repository
@Api(value = "event")
@RequestMapping(value = "/webapi/events")
public class SecurityServiceController {

	private final SecurityEventsRepository repository;

	@Autowired
	public SecurityServiceController(final SecurityEventsRepository repository) {
		this.repository = repository;
	}

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Get events", notes = "Returs registered events")
	public List<RegisteredEvent> getRegisteredEvents() {
		return repository.getEvents();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Create event", notes = "Creates event.")
	public RegisteredEvent createEvent(
			@ApiParam(value = "POST_DATA", required = true) @Valid @RequestBody EventRegistration registrationData) {
		return repository.create(registrationData);
	}

	@RequestMapping(path = "/{eventId}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public RegisteredEvent deleteEvent(@ApiParam(value = "DELETE", required = true) @Valid @PathVariable Long eventId) {
		return repository.delete(eventId);
	}

	@RequestMapping(path = "/{eventId}", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public RegisteredEvent updateEvent(
			@ApiParam(value = "UPDATE_BY_ID", required = true) @Valid @PathVariable Long eventId,
			@ApiParam(value = "UPDATE_TO|LOW|NORMAL|HIGH|", required = true) @Valid @RequestBody RegisteredEventUpdate updateData) {
		return repository.update(eventId, updateData);
	}
	
	@RequestMapping(path = "/{eventId}", method = RequestMethod.GET)
	@ApiOperation(value = "GET")
	@ResponseStatus(HttpStatus.OK)
	public RegisteredEvent findEventById(
			@ApiParam(value = "GET", required = true) @Valid @PathVariable Long eventId) {

		throw new UnsupportedOperationException("not implemented");
	}
	

}
