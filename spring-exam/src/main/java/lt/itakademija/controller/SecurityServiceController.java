package lt.itakademija.controller;

import lt.itakademija.model.EventRegistration;
import lt.itakademija.model.RegisteredEvent;
import lt.itakademija.model.RegisteredEventUpdate;
import lt.itakademija.repository.SecurityEventsRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping(value = "/webapi/events")
public class SecurityServiceController {

	private final SecurityEventsRepository repository;

	@Autowired
	public SecurityServiceController(final SecurityEventsRepository repository) {
		this.repository = repository;
	}

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "GET")
	@ResponseStatus(HttpStatus.OK)
	public List<RegisteredEvent> getRegisteredEvents() {
		// throw new UnsupportedOperationException("not implemented");
		return repository.getEvents();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "POST")
	@ResponseStatus(HttpStatus.CREATED)
	public RegisteredEvent createEvent(
			@ApiParam(value = "POST_DATA", required = true) @Valid @RequestBody EventRegistration registrationData) {
		// throw new UnsupportedOperationException("not implemented");
		return repository.create(registrationData);
	}

	@RequestMapping(path = "/{eventId}", method = RequestMethod.DELETE)
	@ApiOperation(value = "DELETE")
	@ResponseStatus(HttpStatus.OK)
	public RegisteredEvent deleteEvent(
			@ApiParam(value = "DELETE_BY_ID", required = true) @Valid @PathVariable Long eventId) {
		// throw new UnsupportedOperationException("not implemented");
		return repository.delete(eventId);
	}

	@RequestMapping(path = "/{eventId}", method = RequestMethod.PUT)
	@ApiOperation(value = "UPDATE")
	@ResponseStatus(HttpStatus.OK)
	public RegisteredEvent updateEvent(
			@ApiParam(value = "UPDATE_BY_ID", required = true) @Valid @PathVariable Long eventId,
			@ApiParam(value = "UPDATE_TO|LOW|NORMAL|HIGH|", required = true) @Valid @RequestBody RegisteredEventUpdate updateData) {
		// throw new UnsupportedOperationException("not implemented");
		return repository.update(eventId, updateData);
	}

	@RequestMapping(path = "/{eventId}", method = RequestMethod.GET)
	@ApiOperation(value = "GET_BY_ID")
	@ResponseStatus(HttpStatus.OK)
	public RegisteredEvent findEventById(
			@ApiParam(value = "GET_BY_ID", required = true) @Valid @PathVariable Long eventId) {

		RegisteredEvent eventById = null;
		for (RegisteredEvent event : repository.getEvents()) {
			if (event.getId() == eventId) {
				eventById = event;
				break;
			}
		}
		return eventById;
	}
}
