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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.http.HttpStatus;

@Api(value = "Event Calendar", description = "Events handler for the Event Calendar")
@RestController
public class SecurityServiceController {

	private final SecurityEventsRepository repository;

	@Autowired
	public SecurityServiceController(final SecurityEventsRepository repository) {
		this.repository = repository;
	}

	@RequestMapping(value = "/spring-exam/webapi/events", method = RequestMethod.GET)
	@ApiOperation(value = "Get Registered Events")
	@ResponseStatus(HttpStatus.OK)
	public List<RegisteredEvent> getRegisteredEvents() {
		List<RegisteredEvent> registeredEvents = repository.getEvents();
		return registeredEvents;
	}

	@RequestMapping(value = "/spring-exam/webapi/events", method = RequestMethod.POST)
	@ApiOperation(value = "Register an event")
	@ResponseStatus(HttpStatus.CREATED)
	public RegisteredEvent createEvent(
			@ApiParam(value = "Event information", required = true) @Valid @RequestBody EventRegistration registrationData) {
		RegisteredEvent createdEvent = repository.create(registrationData);
		return createdEvent;
	}

	@RequestMapping(value = "/spring-exam/webapi/events/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete Event")
	@ResponseStatus(HttpStatus.OK)
	public RegisteredEvent deleteEvent(
			@ApiParam(value = "Event ID number", required = true) @PathVariable("id") Long id) {
		RegisteredEvent deletedEvent = repository.delete(id);
		return deletedEvent;

	}

	@RequestMapping(value = "/spring-exam/webapi/events/{id}", method = RequestMethod.PUT)
	@ApiOperation(value = "Update event")
	public RegisteredEvent updateEvent(@ApiParam(value = "Event ID number", required = true) @PathVariable("id") Long id,
			@ApiParam(value = "Updated event information", required = true) @Valid @RequestBody RegisteredEventUpdate updateData) {
		RegisteredEvent updatedEvent = repository.update(id, updateData);
		return updatedEvent;
	}
	
	@RequestMapping(path = "/spring-exam/webapi/events/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Get event by ID number")
	public RegisteredEvent getRegisteredEventById(@PathVariable Long id) {
		RegisteredEvent event = repository.findOne(id);
		if (event != null){
			return event;
		}
		return null;
	}

	@RequestMapping(path = "/spring-exam/webapi/events/{dateFrom}/{dateTill}/{location}/{description}", method = RequestMethod.GET)
	@ApiOperation(value = "Get Event sorted by date, location and description")
	public List<RegisteredEvent> getSortedEvents(
			@PathVariable Date dateFrom,
			@PathVariable Date dateTill, 
			@PathVariable String location, 
			@PathVariable String description) {
		
		List<RegisteredEvent> events = repository.sortedEvents(dateFrom, dateTill, location, description);
		return events;
	}
}


