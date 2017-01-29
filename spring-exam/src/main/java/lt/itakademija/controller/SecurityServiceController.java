package lt.itakademija.controller;

import lt.itakademija.model.EventRegistration;
import lt.itakademija.model.RegisteredEvent;
import lt.itakademija.model.RegisteredEventUpdate;
import lt.itakademija.repository.SecurityEventsRepository;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
	@ApiOperation(value = "Get Events")
	@ResponseStatus(HttpStatus.OK)
	public List<RegisteredEvent> getRegisteredEvents() {
		return repository.getEvents();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Create Event")
	@ResponseStatus(HttpStatus.CREATED)
	public RegisteredEvent createEvent(
			@ApiParam(value = "Event data", required = true) @Valid @RequestBody EventRegistration registrationData) {
		return repository.create(registrationData);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete Event")
	@ResponseStatus(HttpStatus.OK)
	public RegisteredEvent deleteEvent(@ApiParam(value = "Event ID", required = true) @PathVariable Long id) {
		return repository.delete(id);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	@ApiOperation(value = "Update Event")
	@ResponseStatus(HttpStatus.OK)
	public RegisteredEvent updateEvent(@ApiParam(value = "Event ID", required = true) @PathVariable Long id,
			@ApiParam(value = "Updated event data", required = true) @Valid @RequestBody RegisteredEventUpdate updateData) {
		return repository.update(id, updateData);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Get Event by ID")
	public RegisteredEvent getRegisteredEventById(@PathVariable Long id) {
		RegisteredEvent event = repository.getEvents().stream().filter(p -> p.getId().equals(id)).findFirst()
				.orElseThrow(() -> new RuntimeException());
		return event;
	}

	@RequestMapping(path = "/{dateFrom}/{dateTill}/{location}/{description}", method = RequestMethod.GET)
	@ApiOperation(value = "Get Event by date interval, location and description")
	public List<RegisteredEvent> getEventByDateIntervalLocationDescription(
			@PathVariable Date dateFrom,
			@PathVariable Date dateTill, 
			@PathVariable String location, 
			@PathVariable String description) {
		List<RegisteredEvent> events = repository.getEvents()
				.stream()
				.filter(l -> l.getLocation().contains(location) && l.getDescription().contains(description)
						&& l.getRegistrationDate().after(dateFrom) && l.getRegistrationDate().before(dateTill))
				.collect(Collectors.toList());
		return events;
	}
}
